import React, { Component } from 'react'
import { View, StyleSheet, Picker, Text } from 'react-native'
import { Input, Button } from 'react-native-elements'
import { KeyboardAwareScrollView } from 'react-native-keyboard-aware-scroll-view'

export default class ImportCourse extends Component {
  static navigationOptions = ({ navigation }) => ({
    title: '导入课程'
  })

  _renderScoolYear = () => {
    years = []
    for (let i = 2010; i < 2018; ++i)
      years.push(i)

    return years.map(year => <Picker.Item label={`${year} - ${year + 1}学年`} value='' />)
  }

  _renderSchools = () => {
    return schools.map(school => <Picker.Item label='同济大学' value={school.schoolId} />)
  }

  render() {
    return (
      <KeyboardAwareScrollView
        scrollEnabled={false}
        contentContainerStyle={styles.container }
      >
        <Input
          label='请选择学校'
          inputComponent={() =>
            <View style={styles.pickerWrapper}>
              <Picker style={{ flex: 1 }}>
                {this._renderSchools()}
              </Picker>
            </View>
          }
          labelStyle={styles.label}
          containerStyle={styles.wrapper}
          inputContainerStyle={{ borderBottomWidth: 0 }}
        />
        <Input
          label='请选择学年和学期'
          inputComponent={() =>
            <View style={styles.pickerWrapper}>
              <Picker style={{ flex: 1 }}>
                {this._renderScoolYear()}
              </Picker>
              <Picker style={{ flex: 1 }}>
                <Picker.Item label='第一学期' value='0' />
                <Picker.Item label='第二学期' value='1' />
              </Picker>
            </View>
          }
          labelStyle={styles.label}
          containerStyle={styles.wrapper}
          inputStyle={styles.input}
          inputContainerStyle={{ borderBottomWidth: 0 }}
        />
        <Input
          label='学号'
          labelStyle={styles.label}
          containerStyle={styles.wrapper}
          inputStyle={styles.input}
          inputContainerStyle={{ borderBottomWidth: 0 }}
        />
        <Input
          label='密码'
          labelStyle={styles.label}
          containerStyle={styles.wrapper}
          inputStyle={styles.input}
          inputContainerStyle={{ borderBottomWidth: 0 }}
        />
        <Button
          clear
          title='导入'
          containerStyle={{
            margin: 30,
            width: 200,
            backgroundColor: '#8BC34A'
          }}
        />
      </KeyboardAwareScrollView>
    )
  }
}


var styles = StyleSheet.create({
  container: {
    flex: 1,
    flexDirection: 'column',
    backgroundColor: '#fafafa',
    alignItems: 'center'
  },
  pickerWrapper: {
    flexDirection: 'row',
    borderWidth: 1,
    borderColor: '#ccc',
    borderRadius: 5
  },
  input: {
    borderWidth: 1,
    borderColor: '#ccc',
    height: 50,
    paddingLeft: 10,
    borderRadius: 5,
    marginLeft: 0
  },
  wrapper: {
    margin: 10,
  },
  label: {
    marginBottom: 5
  }
});

const schools = [
  {
    schoolId: 1,
    schoolName: '同济大学'
  }
]