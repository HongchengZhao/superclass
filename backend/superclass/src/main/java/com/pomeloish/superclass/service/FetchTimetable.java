package com.pomeloish.superclass.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.net.URL;


import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlButtonInput;
import com.gargoylesoftware.htmlunit.util.NameValuePair;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.HttpMethod;

import org.w3c.dom.Node;

import com.pomeloish.superclass.dao.CourseMapper;
import com.pomeloish.superclass.model.Course;
import com.pomeloish.superclass.service.CourseServiceImpl;
import com.pomeloish.superclass.model.TimeSlot;
import com.pomeloish.superclass.dao.TimeSlotMapper;
import com.pomeloish.superclass.service.TimeSlotService;

public class FetchTimetable {

    public static String homePage(String eduId, String password){
        final WebClient webClient = new WebClient();
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setTimeout(20000);

        try {
            final HtmlPage loginPage = webClient.getPage("https://ids.tongji.edu.cn:8443/nidp/saml2/sso?id=3397&sid=1&option=credential&sid=1");

            // Get Security Code
            final DomNodeList<DomNode> securityCodeDivs = loginPage.querySelectorAll("div#ehong-code>font");
            String securityCode = "";
            for (DomNode div: securityCodeDivs) {
                securityCode += div.getTextContent();
            }

            // Get Login Form
            final HtmlForm form = loginPage.getFormByName("IDPLogin");
            final HtmlTextInput eduIdField = form.getInputByName("Ecom_User_ID");
            final HtmlPasswordInput passwordField = form.getInputByName("Ecom_Password");
            final HtmlTextInput securityCodeField = form.getInputByName("Txtidcode");
            final HtmlButtonInput submit = form.getInputByName("btsubmit");

            eduIdField.type(eduId);
            passwordField.type(password);
            securityCodeField.type(securityCode);
            submit.click();
            webClient.waitForBackgroundJavaScript(5000);

            webClient.getPage("http://4m3.tongji.edu.cn/eams/home.action");

            final ArrayList<NameValuePair> params = new ArrayList<>(Arrays.asList(
                    new NameValuePair("ids", "922100930"),  // 每个人不一样，还有待研究
                    new NameValuePair("ignoreHead", "1"),
                    new NameValuePair("project.id","1"),
                    new NameValuePair("semester.id","106"),
                    new NameValuePair("setting.kind","std"),
                    new NameValuePair("startWeek","1")
            ));
            final WebRequest getCourseTable = new WebRequest(new URL("http://4m3.tongji.edu.cn/eams/courseTableForStd!courseTable.action"), HttpMethod.POST);
            getCourseTable.setRequestParameters(params);

            // Timetable Page
            final HtmlPage timetablePage = webClient.getPage(getCourseTable);

            final DomNode courseTable = timetablePage.getElementById("grid1058628852_data");
            for (DomNode course: courseTable.getChildren()) {
                getCourseInfo(course);
            }


            return timetablePage.asXml();


            //final String pageAsXml = page.asXml();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            webClient.close();
        }
        return null;
    }


    private static String getCourseInfo(DomNode course){
       ArrayList<DomNode> courseInfo = (ArrayList<DomNode>)course.getChildren();

        DomNode courseIdNode = courseInfo.get(1);
        String courseId = courseIdNode.getTextContent();

        DomNode courseNameNode = courseInfo.get(2);
        String courseName = courseNameNode.getTextContent();

        DomNode teacherNameNode = courseInfo.get(7);
        String teacherName = teacherNameNode.getTextContent();


        //将从页面解析得到的courseInfo存入数据库中
        int school_id=1;                //暂时只针对同济大学获取课表信息，school_id为1
        Course course1=new Course(courseId,school_id,courseName,teacherName);
        new CourseServiceImpl().insert(course1);

        //得到courseInfo后需进一步分析以获取详细的上课信息classInfo
        DomNode classInfoNode = courseInfo.get(8);
        ArrayList<DomNode> classInfoList = (ArrayList<DomNode>)classInfoNode.getChildNodes();
        for (DomNode classInfo : classInfoList){
            if (classInfo.getNodeType() == Node.TEXT_NODE)
                getClassInfo(classInfo);
        }

       return "";
    }

    private static void getClassInfo(DomNode classInfo){

        //下面的其实是TimeSlot的信息
        String[] classDetails = classInfo.getTextContent().split(" ");

        int weekday = WeekDay.getIndexOf(classDetails[1]);

        String[] classSpan = classDetails[2].split("-");
        int startTime = Integer.parseInt(classSpan[0]);
        int endTime = Integer.parseInt(classSpan[1]);

        int weekInterval = 0;
        String weekTime;
        if (classDetails[3].charAt(0) != '['){
            weekInterval = 1;
            weekTime= classDetails[3].substring(2, classDetails[3].length()-2);
        } else{
            weekTime = classDetails[3].substring(1, classDetails[3].length()-1);
        }
        String[] weekSpan = weekTime.split("-");
        int startWeek = Integer.parseInt(weekSpan[0]);
        int endWeek = Integer.parseInt(weekSpan[1]);

        //向数据库中插入timeSlot的信息
        int timeSlotId=1;
        //只有当timeSlot的信息不完全一样的时候再存入数据库，并且每当有新的timeSlotId存入，其值自动加1
        TimeSlot timeSlot = new TimeSlot(timeSlotId, weekday, startWeek, endWeek, startTime, endTime, weekInterval);
        new TimeSlotServiceImpl().insert(timeSlot);

        //数据库中已经有了有了Course，TimeSlot的信息，再保存class的信息即可

        String classRoom = classDetails[4];

        // 操作数据库
        //与将courseInfo保存到数据库操作一样
        //但是要比对class的上课时间表与TimeSlot数据库中已有的数据，以确定class的timeSlotId值
        //以及对应的课程信息也要查询Course表，以确定Course的具体CourseId值

        //  假装是一个函数
         new    TimeSlotServiceImpl().selectAll()


    }
}

enum WeekDay{
    Mon("星期一", 1),
    Tue("星期二", 2),
    Wed("星期三", 3),
    Thu("星期四", 4),
    Fri("星期五", 5),
    Sat("星期六", 6),
    Sun("星期日", 7);

    private final String day;
    private final int index;
    WeekDay(String day, int index) {
        this.day = day;
        this.index = index;
    }

    public String getDay() {
        return day;
    }

    public int getIndex() {
        return index;
    }

    static int getIndexOf(String aDay){
        for (WeekDay day : WeekDay.values()){
            if (aDay == day.getDay())
                return day.getIndex();
        }
        return -1;
    }
}