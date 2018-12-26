import React, { Component } from 'react';
import { View, Text, SectionList, FlatList, StyleSheet, Dimensions } from 'react-native';
import { ListItem, Divider } from 'react-native-elements';

export default class ClassMembersScreen extends Component {
  static navigationOptions = {
    title: 'Class Members'
  }

  constructor() {
    super()
    this.state = {
      sections: null
    }
  }

  componentDidMount() {
    if (!this.props.smallScreen) {
      this.setState({
        sections: [
          { key: 'Teachers', data: teachers },
          { key: 'Students', data: students }
        ]
      })
    }
  }

  _renderSectionHeader = ({ section }) => <Text style={styles.sectionHeader}>{section.key}</Text>

  _keyExtractor = (item) => item._id.toString()

  _renderItem = ({ item }) => {
    let smallScreen = this.props.smallScreen
    return (
      <ListItem
        key={item._id}
        leftAvatar={{
          size: 'medium',
          title: item.name[0],
          placeholderStyle: { backgroundColor: 'red' },
          titleStyle: { lineHeight: 50 },
          source: { uri: item.avatar_url, cache: 'force-cache' },
          ImageComponent: () => <Image />
        }}
        title={item.name}
        titleProps={{ numberOfLines: 1, ellipsizeMode: 'tail' }}
        titleStyle={smallScreen ? { fontSize: 12 } : null}
        containerStyle={smallScreen ? styles.smallScreenItem : null}
      />)
  }
  /*
  item.avatar_url && */
  render() {
    let smallScreen = this.props.smallScreen

    return (
      <View
        style={{
          height: smallScreen ? 'auto' : '100%',
          backgroundColor: smallScreen ? 'transparent' : '#fafafa'
        }}
      >
        {this.state.sections ?
          <SectionList
            sections={this.state.sections}
            renderSectionHeader={this._renderSectionHeader}
            renderItem={this._renderItem}
            keyExtractor={this._keyExtractor}
            ItemSeparatorComponent={() => <Divider style={{ backgroundColor: '#eee' }} />}
          /> :
          <View style={{ flexDirection: 'row', flexWrap: 'wrap' }} >
            {teachers.map((item) => this._renderItem({ item }))}
            {students.map((item) => this._renderItem({ item }))}
          </View>
        }
      </View>
    )
  }
}

const teachers = [
  {
    _id: 1,
    name: 'pomevak',
    avatar_url: 'http://www.jituwang.com/uploads/allimg/150922/258230-150922221K447.jpg'
  }
]

const students = [
  {
    _id: 3,
    name: 'lostcute',
    avatar_url: 'http://www.jituwang.com/uploads/allimg/150922/258230-150922221K447.jpg'
  },
  {
    _id: 4,
    name: 'yuzu',
    avatar_url: null
  },
  {
    _id: 4,
    name: 'yuzu',
    avatar_url: 'http://www.jituwang.com/uploads/allimg/150922/258230-150922221K447.jpg'
  },
  {
    _id: 4,
    name: 'yuzu',
    avatar_url: 'http://www.jituwang.com/uploads/allimg/150922/258230-150922221K447.jpg'
  },
  {
    _id: 4,
    name: 'yuzu',
    avatar_url: 'http://www.jituwang.com/uploads/allimg/150922/258230-150922221K447.jpg'
  },
  {
    _id: 4,
    name: 'yuzu',
    avatar_url: 'http://www.jituwang.com/uploads/allimg/150922/258230-150922221K447.jpg'
  },
  {
    _id: 4,
    name: 'yuzu',
    avatar_url: 'http://www.jituwang.com/uploads/allimg/150922/258230-150922221K447.jpg'
  }
]

const SCREEN_WIDTH = Dimensions.get('window').width;
const styles = StyleSheet.create({
  sectionHeader: {
    paddingLeft: 10,
    color: '#999',
    backgroundColor: '#fafafa',
    height: 30,
    lineHeight: 30,
    fontWeight: '300'
  },
  smallScreenItem: {
    width: (SCREEN_WIDTH - 32) / 5,
    flexDirection: 'column',
    padding: 5,
    backgroundColor: 'transparent'
  }
})