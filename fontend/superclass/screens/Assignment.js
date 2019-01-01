import React, { Component } from 'react'
import { View, ScrollView, Text, TextInput, StyleSheet, FlatList } from 'react-native'
import LinearGradient from 'react-native-linear-gradient'
import TouchableScale from 'react-native-touchable-scale'
import { ListItem, Button } from 'react-native-elements'

import { HeaderButton } from '../components'


export default class Assignment extends Component {
  static navigationOptions = ({ navigation }) => ({
    title: '作业',
    headerRight:
      <HeaderButton
        icon={{ name: 'plus', color: 'white', type: 'material-community' }}
        onPress={() => navigation.navigate('CreateAssignment')}
      />
  })

  constructor() {
    super()
    this.state = {
      createAssignmentVisibility: false,
      activeSections: []
    }
  }

  _keyExtractor = (item) => item._id

  _renderItem = ({ item, index }) => (
    <ListItem
      component={TouchableScale}
      friction={10}
      tension={100}
      activeScale={0.9}
      ViewComponent={LinearGradient}
      linearGradientProps={{
        colors: ['#3498db', '#00BCD4'],
        start: { x: 0.0, y: 0.0 },
        end: { x: 1.0, y: 1.0 }
      }}
      title={item.title}
      leftElement={<Text style={{ color: '#ecf0f1' }}>#{index + 1}</Text>}
      containerStyle={styles.assignment}
      titleStyle={{ color: '#ecf0f1' }}
      chevronColor='#ecf0f1'
      chevron
      onPress={() => this.props.navigation.navigate('AssignmentDetail', {
        assignment: item
      })}
    />
  )

  render() {
    return (
      <ScrollView style={{ backgroundColor: '#fafafa', paddingVertical: 5 }}>
        <FlatList
          data={assignmentList}
          keyExtractor={this._keyExtractor}
          renderItem={this._renderItem}
        />
      </ScrollView>
    )
  }
}

const assignmentList = [
  {
    _id: 1,
    title: 'Assignment One',
    content: 'faljflajflajflajldjaljadjfladjflakjkdaljfkafla;ak;lfafdasadsddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd',
    creation_time: '2018-12-3 12:00',
    deadline: '2018-12-3 12:00'
  },
  {
    _id: 2,
    title: 'Assignment One',
    content: 'faljflajflajflajldjaljadjfladjflakjkdaljfkafla;ak;lfafdasadsddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd',
    creation_time: '2018-12-3 12:00',
    deadline: '2018-12-3 12:00'
  },
  {
    _id: 3,
    title: 'Assignment One',
    content: 'faljflajflajflajldjaljadjfladjflakjkdaljfkafla;ak;lfafdasadsddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd',
    creation_time: '2018-12-3 12:00',
    deadline: '2018-12-3 12:00'
  },
  {
    _id: 4,
    title: 'Assignment One',
    content: 'faljflajflajflajldjaljadjfladjflakjkdaljfkafla;ak;lfafdasadsddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd',
    creation_time: '2018-12-3 12:00',
    deadline: '2018-12-3 12:00'
  }
]


const styles = StyleSheet.create({
  assignment: {
    elevation: 4,
    marginHorizontal: 10,
    backgroundColor: '#2ecc71',
    marginVertical: 5
  }
});