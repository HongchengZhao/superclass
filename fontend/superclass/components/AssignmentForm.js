import React, { Component} from 'react'
import { Dimensions, ScrollView, StyleSheet } from 'react-native'
import { Input } from 'react-native-elements'
import DatePicker from 'react-native-datepicker'

const SCREEN_WIDTH = Dimensions.get('window').width

export default class AssignmentForm extends Component {

  constructor() {
    super()
    this.state = {
      editable: false,
      detailHeight: 0
    }
  }

  _onHeightChange = (event) => {
    this.setState({
      detailHeight: event.nativeEvent.contentSize.height
    })
  }

  render(){
    const assignment = this.props.assignment
    return (
      <ScrollView
        style={styles.wrapper}
        contentContainerStyle={{ alignItems: 'center'}}
      >
        <Input
          label={'标题'}
          labelStyle={styles.label}
          inputContainerStyle={styles.inputContainer}
          inputStyle={styles.input}
          defaultValue={assignment.title}
          containerStyle={styles.container}
        />
        <Input
          label={'发布时间'}
          labelStyle={styles.label}
          inputContainerStyle={styles.inputContainer}
          inputStyle={styles.input}
          defaultValue={assignment.creation_time}
          containerStyle={styles.container}
        />
        <Input
          editable={false}
          label={'截止时间'}
          labelStyle={styles.label}
          inputContainerStyle={styles.inputContainer}
          inputComponent={()=>
            <DatePicker
              dateInput={assignment.deadline}
              //disabled={!this.state.editable}
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
        <Input
          multiline
          label={'描述'}
          labelStyle={styles.label}
          defaultValue={assignment.content}
          inputContainerStyle={styles.inputContainer}
          inputStyle={[styles.input, { height: Math.max(40, this.state.detailHeight) }]}
          onChange={this._onHeightChange}
          containerStyle={styles.container}
        />
      </ScrollView>
    )
  }
}


const styles = StyleSheet.create({
  wrapper:{
    flex:1,
    backgroundColor: 'white',
  },
  container: {
    paddingVertical: 5,
    flexDirection: 'row',
    flex: 1
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
    flex: 1,
  },
  input: {
    fontSize: 16,
  },
})