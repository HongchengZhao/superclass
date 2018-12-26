import React, { Component } from 'react';
import { View, Image, FlatList, StatusBar } from 'react-native';
import { ListItem, Divider } from 'react-native-elements';

export default class ClassGroupScreen extends Component {
  static navigationOptions = {
    title: 'Class',
  };

  constructor() {
    super();
    this.state = {
      classList: classList
    }
  }

  componentDidMount() {
  }

  _keyExtractor = (item) => item._id.toString()

  _renderItem = ({ item }) => (
    <ListItem
      key={item._id}
      leftAvatar={{
        size: 'medium',
        source: {
          uri: item.avatar_url,
          cache: 'force-cache'
        },
        ImageComponent: () => <Image />
      }}
      title={item.name}
      subtitle={item.latest_message}
      containerStyle={{padding: 5}}












      
      onPress={() => this.props.navigation.navigate('GroupChat', {
        name: item.name
      })}
    />
  )

  render() {
    return (
      <View style={{ flex: 1, backgroundColor: '#fafafa' }}>

        <StatusBar
          barStyle='light-content'
          backgroundColor='#2196F3'
        />


        <FlatList
          data={this.state.classList}
          renderItem={this._renderItem}
          keyExtractor={this._keyExtractor}
          ItemSeparatorComponent={() => <Divider style={{ backgroundColor: '#eee' }} />}
          ListHeaderComponent={<Divider style={{ backgroundColor: '#eee' }} />}
          ListFooterComponent={<Divider style={{ backgroundColor: '#eee' }} />}
        />
      </View>
    );
  }
}

const classList = [
  {
    _id: 1,
    name: 'Amy Farha',
    avatar_url: 'http://www.jituwang.com/uploads/allimg/150922/258230-150922221K447.jpg',
    latest_message: 'Vice President'
  },
  {
    _id: 2,
    name: 'Chris Jackson',
    avatar_url: 'http://www.jituwang.com/uploads/allimg/150922/258230-150922221K447.jpg',
    latest_message: 'Vice Chairman'
  },
]