package com.superclass.service;

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

            // 从这个地方开始写
            // 
            // 
            // 
            // 
            // 
            // 
            // 
            /*
            final DomNode courseTable = timetablePage.getElementById("grid1058628852_data");
            for (DomNode course: courseTable.getChildren()) {
                getCourseInfo(course);
            }*/


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
        return "";
    }
}
