import React, { Component } from 'react'
import { View, Dimensions, ScrollView, StyleSheet, Text } from 'react-native'
import { Input, ListItem, Button } from 'react-native-elements'
import DatePicker from 'react-native-datepicker'

import { AssignmentForm } from '../components'

const SCREEN_WIDTH = Dimensions.get('window').width

export default class AssignmentDetail extends Component {

  static navigationOptions = ({ navigation }) => ({
    tabBarLabel: '作业详情'
  })

  constructor() {
    super()
    this.state = {
      editable: false,
      descriptHeight: 0
    }
  }

  render() {
    const navigation = this.props.navigation
    const assignment = navigation.getParam('assignment')

    return (
      <View style={{ flex: 1, backgroundColor: '#fafafa' }}>
        <AssignmentForm assignment/>
        <Button
          icon={{
            name: 'edit',
            color: 'white'
          }}
          title='编辑'
          buttonStyle={styles.editBtn}
          containerStyle={styles.editContainer}
        />
      </View>
    )
  }
}

const styles = StyleSheet.create({
  sectionContent: {
  },
  container: {
    paddingVertical: 5,
    flexDirection: 'row'
  },
  label: {
    width: 80,
    height: 40,
    marginRight: 10,
    fontWeight: 'normal',
    lineHeight: 40,
    color: '#86939e',
    fontSize: 14
  },
  inputContainer: {
    borderBottomWidth: 0
  },
  input: {
    fontSize: 16
  },
  editContainer: {
    position: 'absolute',
    bottom: 0,
    left: 0,
    width: '100%',
    backgroundColor: '#eee',
    height: 50,
    padding: 5
  },
  editBtn: {
    flexDirection: 'row-reverse',
    width: '100%',
    backgroundColor: '#8BC34A',
    elevation: 0,
    shadowOpacity: 0,
    shadowColor: 'transparent'
  }
})


/*
 <ScrollView>
          <ListItem
            leftElement={<Text style={styles.label}>标题</Text>}
            title={
              <Input
                editable={this.state.editable}
                containerStyle={{ width: SCREEN_WIDTH - 130 }}
                defaultValue={assignment.title}
                inputContainerStyle={styles.inputContainer}
                inputStyle={styles.input}
              />
            }
            containerStyle={styles.container}
          />
          <ListItem
            leftElement={<Text style={styles.label}>发布时间</Text>}
            title={
              <Input
                editable={false}
                containerStyle={{ width: SCREEN_WIDTH - 130 }}
                defaultValue={assignment.creation_time}
                inputContainerStyle={styles.inputContainer}
                inputStyle={styles.input}
              />
            }
            containerStyle={styles.container}
          />
          <ListItem
            leftElement={<Text style={styles.label}>截止时间</Text>}
            title={
              <DatePicker
                dateInput={assignment.deadline}
                disabled={!this.state.editable}
                mode="datetime"
                minDate="1950-01-01 00:00:00"
                maxDate="2050-12-31 24:59:59"
                confirmBtnText="Confirm"
                cancelBtnText="Cancel"
                is24Hour={true}
                showIcon={false}
                customStyles={{
                  dateInput: { borderWidth: 0, alignItems: 'flex-start', justifyContent: 'flex-start' },
                  dateText: { color: 'black', fontSize: 16, lineHeight: 40, paddingLeft: 15 },
                  disabled: { backgroundColor: 'transparent' },
                }}
                style={{ width: SCREEN_WIDTH - 130 }}
                onDateChange={(date) => { this.setState({ date: date }) }}
              />
            }
            containerStyle={styles.container}
          />
          <ListItem
            leftElement={<Text style={styles.label}>描述</Text>}
            title={
              <Input
                multiline
                editable={false}
                containerStyle={{ width: SCREEN_WIDTH - 20 }}
                defaultValue={assignment.content}
                inputContainerStyle={[styles.inputContainer, { alignItems: 'flex-start' }]}
                inputStyle={[styles.input, { height: Math.max(40, this.state.detailHeight) }]}
                onChange={this._onHeightChange}
              />
            }
            containerStyle={styles.container}
          />


        </ScrollView>

 */