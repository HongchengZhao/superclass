import React, { Component } from 'react'
import { View, ScrollView, StyleSheet, Text } from 'react-native'
import { Button } from 'react-native-elements'
import { Col, Row, Grid } from 'react-native-easy-grid'

import HeaderRightButton from '../components/HeaderButton'
import ImportCourse from './ImportCourse'

import { ChineseColors, ChineseColorNames } from '../modules/Colors'

export default class CourseTable extends Component {
  static navigationOptions = ({ navigation }) => ({
    title: '课程表',
    headerRight:
      <HeaderRightButton
      icon={{ name: 'plus', color: 'white', type: 'material-community' }}
      onPress={()=> navigation.navigate('ImportCourse')}
      />
  })

  constructor() {
    super()
    this.state = {
      sections: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12],
      weekdays: ['周一', '周二', '周三', '周四', '周五', '周六', '周日'],
      classes: null
    }
  }

  componentDidMount() {
    tmp = [[], [], [], [], [], [], []]

    classList.sort((a, b) => a.startTime - b.startTime)
    classList.forEach(ele => {
      tmp[ele.day - 1].push(ele)
    })

    this.setState({ classes: tmp })
  }

  _renderTableHead = () => {
    return this.state.weekdays.map((item) =>
      <Col style={styles.thead} size={3}>
        <Text>{item}</Text>
      </Col>
    )
  }

  _renderClasses = () => {
    cols = []

    this.state.classes.forEach(list => {
      col = []
      cnt = 0
      lastEndTime = 0

      list.forEach(cls => {
        for (i = lastEndTime + 1; i < cls.startTime; ++i) {
          col.push(<Row style={styles.emptyCell} size={1}/>)
          ++cnt
        }

        span = cls.endTime - cls.startTime + 1
        index = cls.classId % 10
        color = ChineseColors[ChineseColorNames[index]]
        col.push(
          <Row style={styles.classGrid} size={span}>
            <View style={[styles.classInfo, { backgroundColor: color }]}>
              <Text style={styles.baseText}>{cls.className}</Text>
              <Text style={styles.baseText}>{'@' + cls.classroom}</Text>
            </View>
          </Row>
        )
        cnt += span
        lastEndTime = cls.endTime
      })

      while (cnt < 12) {
        col.push(<Row style={styles.emptyCell} size={1}/>)
        ++cnt
      }
      cols.push(<Col size={3}>{col}</Col>)
    })

    return cols
  }

  render() {
    return (
      <View style={{ flex: 1 }}>
        <Grid>
          <Row style={styles.theadWrapper}>
            <Col style={styles.thead} size={2}>
              <Text style={{ fontSize: 10 }}>{'12\n月'}</Text>
            </Col>
            {this._renderTableHead()}
          </Row>
        </Grid>

        <ScrollView
          style={{ marginTop: 50 }}
          showsVerticalScrollIndicator={false}
        >
          <Grid style={{ height: 600 }}>
            <Col style={styles.rheadWrapper} size={2}>
              {
                this.state.sections.map((item) =>
                  <Row style={styles.rhead}>
                    <Text>{item}</Text>
                  </Row>
                )
              }
            </Col>
            {this.state.classes && this._renderClasses()}
          </Grid>
        </ScrollView>
      </View>
    )
  }
}

const styles = StyleSheet.create({
  theadWrapper: {
    height: 50,
    borderBottomWidth: 0.5,
    borderBottomColor: '#eee'
  },
  thead: {
    padding: 5,
    justifyContent: 'center',
    alignItems: 'center',
    overflow: 'hidden'
  },
  rheadWrapper: {
    borderRightColor: '#eee',
    borderRightWidth: 0.5
  },
  rhead: {
    padding: 5,
    justifyContent: 'center',
    alignItems: 'center',
    overflow: 'hidden',
    fontSize: 10
  },
  emptyCell: {
    borderBottomColor: ChineseColors.Silver,
    borderBottomWidth: 0.5,
    borderStyle: 'dashed'
  },
  classGrid: {
    borderBottomColor: ChineseColors.Silver,
    borderBottomWidth: 0.5,
    borderStyle: 'dashed'
  },
  classInfo: {
    flex: 1,
    flexDirection: 'column',
    borderRadius: 5,
    padding: 2,
    margin: 2
  },
  baseText: {
    color: 'white',
    fontSize: 12
  }
})

const classList = [
  {
    classId: 1,
    className: '数字图像处理',
    classroom: '专用教室',
    day: 1,
    startWeek: 2,
    endWeek: 16,
    interval: 1,
    startTime: 3,
    endTime: 4
  },
  {
    classId: 2,
    className: '编译原理',
    classroom: '安楼A204',
    day: 1,
    startWeek: 1,
    endWeek: 17,
    interval: 0,
    startTime: 5,
    endTime: 6
  },
  {
    classId: 3,
    className: '软件工程',
    classroom: '专用教室',
    day: 3,
    startWeek: 1,
    endWeek: 17,
    interval: 0,
    startTime: 3,
    endTime: 4
  }
]