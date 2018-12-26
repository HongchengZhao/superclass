import React, { Component } from 'react';
import {
  StyleSheet,
  Text,
  View,
  Image,
  ScrollView,
  Dimensions
} from 'react-native';
import { ListItem, Button, ButtonGroup } from 'react-native-elements';
import Swiper from 'react-native-swiper';
import ClassMembersScreen from './ClassMembersScreen';

const SCREEN_HEIGHT = Dimensions.get('window').height;

export default class ClassDetailScreen extends Component {
  static navigationOptions = ({ navigation }) => ({
    headerTransparent: true,
    headerStyle: {
      backgroundColor: 'transparent'
    }
  })

  render() {
    return (
      <ScrollView style={{ backgroundColor: '#fafafa' }}>
        <Swiper
          height={0.3 * SCREEN_HEIGHT}
          paginationStyle={{ marginBottom: -20 }}
          autoplay
        >
          <View style={styles.container}>
            <Text>Notice1</Text>
          </View>
          <View style={styles.container}>
            <Text>Notice2</Text>
          </View>
          <View style={styles.container}>
            <Text>Notice3</Text>
          </View>
        </Swiper>
        <ListItem
          title={
            <ListItem
              chevron
              title='Members'
              rightTitle='68'
              rightContentContainerStyle={{ marginRight: -10 }}
              containerStyle={{ padding: 0, marginBottom: 10, backgroundColor: 'transparent' }}
            />}
          subtitle={<ClassMembersScreen smallScreen />}
          onPress={() => this.props.navigation.navigate('ClassMembers')}
          containerStyle={{ borderColor: '#eee', borderBottomWidth: 0.5 }}
        />
        <View style={styles.actionsContainer}>
          <ListItem
          title='Assignment'
          leftIcon={{ name: 'file-text-o', type: 'font-awesome', color: '#999'}}
          containerStyle={styles.action}
          onPress={()=>this.props.navigation.navigate('Assignment')}
          />
          <ListItem
          title='Sign in'
          leftIcon={{ name: 'pencil-square-o', type: 'font-awesome', color: '#999'}}
          containerStyle={styles.action}
          onPress={()=>this.props.navigation.navigate('RollCall')}
          />
        </View>
      </ScrollView>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#ddd'
  },
  actionsContainer: {
    flexDirection: 'row',
    backgroundColor: 'white',
    marginTop: 20,
    borderColor: '#eee',
    borderBottomWidth: 0.5,
    borderTopWidth: 0.5,
    height: 80
  },
  action: {
    flex: 1,
    flexDirection: 'column'
  }
})