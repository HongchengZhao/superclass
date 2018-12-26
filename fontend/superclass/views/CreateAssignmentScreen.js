import React, { Component } from 'react'
import { View, ScrollView, Dimensions, StyleSheet, Text } from 'react-native'
import { Input, ListItem, Button } from 'react-native-elements'
import DatePicker from 'react-native-datepicker'

const SCREEN_WIDTH = Dimensions.get('window').width

export default class CreateAssignmentScreen extends Component {
  static navigationOptions = ({ navigation }) => ({
    title: '发布新作业'
  })

  constructor() {
    super()
    this.state = {
      descriptHeight: 0
    }
  }

  _onDescriptChange = (event) => {
    this.setState({
      descriptHeight: event.nativeEvent.contentSize.height
    })
  }

  render() {
    return (
      <View>
        <ScrollView>
          <ListItem
            leftElement={<Text style={styles.label}>标题</Text>}
            title={
              <Input
                containerStyle={{ flex: 1 }}
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
                style={{ flex: 1 }}
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
                containerStyle={{ flex: 1 }}
                inputContainerStyle={[styles.inputContainer, { alignItems: 'flex-start' }]}
                inputStyle={[styles.input, { height: Math.max(40, this.state.descriptHeight) }]}
                onChange={this._onDescriptChange}
              />
            }
            containerStyle={styles.container}
          />
        </ScrollView>
      </View>
    )
  }
}



const styles = StyleSheet.create({
  sectionContent: {
  },
  headerRight: {
    margin: 13,
    width: 30,
    height: 30,
    backgroundColor: 'transparent',
    borderRadius: 30
  },
  container: {
    paddingVertical: 5
  },
  label: {
    width: 80,
    height: 40,
    marginRight: 10,
    fontWeight: 'normal',
    lineHeight: 40,
    color: '#86939e'
  },
  inputContainer: {
    borderWidth: 0.5,
    borderRadius: 5,
    borderColor: '#000'
  },
  input: {
    fontSize: 16,
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