import React, { Component } from 'react'
import { View, Text, StyleSheet, TouchableHighlight, Dimensions } from 'react-native'
import { ListItem, Button } from 'react-native-elements'
import { SwipeListView } from 'react-native-swipe-list-view'

const SCREEN_WIDTH = Dimensions.get('window').width

export default class SubmissionScreen extends Component {
  static navigationOptions = ({ navigation }) => ({
    tabBarLabel: '提交情况'
  })

  constructor() {
    super()
  }


  _keyExtractor = (item, index) => index

  _renderItem = (data) => (
    <ListItem
      leftIcon={{
        name: 'file-document',
        type: 'material-community',
        color: '#00BCD4',
        size: 40,
        containerStyle: { marginLeft: 10 }
      }}
      title={data.item.title}
      contentContainerStyle={styles.contentContainer}
      containerStyle={styles.rowFront}
    />
  )

  _renderHiddenItem = () =>(
  <View style={styles.rowBack}>
    <Button
    clear
      title='删除'
      containerStyle={styles.btnWrapper}
    />
  </View>
  )


  render() {
    return (
      <View style={{ flex: 1, backgroundColor: '#fafafa' }}>
        <SwipeListView
          useFlatList
          data={submissions}
          keyExtractor={this._keyExtractor}
          renderItem={this._renderItem}
          renderHiddenItem={this._renderHiddenItem}
          disableRightSwipe
          closeOnScroll
          closeOnRowPress
          closeOnRowOpen
          stopRightSwipe={-90}
          rightOpenValue={-75}
          />
        <Button
        icon={{
          name: 'file-upload',
          color: 'white'
        }}
        title='上传作业'
        buttonStyle={styles.uploadBtn}
        containerStyle={styles.uploadContainer}
        />
      </View>
    )
  }
}

const styles = StyleSheet.create({
  rowFront: {
    alignItems: 'center',
    backgroundColor: '#fff',
    padding: 0,
    justifyContent: 'center',
    height: 60,
  },
  contentContainer: {
    height: '100%',
    borderBottomWidth: 0.8,
    borderBottomColor: '#fafafa',
    marginLeft: -10
  },
  rowBack: {
    alignItems: 'center',
    height: 60,
    borderBottomColor: '#fafafa',
    borderBottomWidth: 0.8,
    backgroundColor: '#e4421e',
    flexDirection: 'row-reverse',
    justifyContent: 'flex-start',
  },
  btnWrapper: {
    width: 75,
    height: '100%',
    justifyContent: 'center',
    alignItems: 'center'
  },
  uploadContainer: {
    position: 'absolute',
    bottom: 0,
    left: 0,
    width: '100%',
    backgroundColor: '#eee',
    height: 50,
    padding: 5
  },
  uploadBtn: {
    flexDirection: 'row-reverse',
    width: '100%',
    backgroundColor: '#8BC34A',
    elevation: 0,
    shadowOpacity: 0,
    shadowColor: 'transparent'
  }
})

const submissions = [
  {
    title: '第一次作业'
  },
  {
    title: '第二次作业'
  },
  {
    title: '第三次作业'
  },
]
