/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow
 */

import React, {Component} from 'react';
import {Platform, Text, View} from 'react-native';
import { createStackNavigator, createAppContainer } from 'react-navigation';
import LoginScreen from './views/LoginScreen';
import SignupScreen from './views/SignupScreen';

const AppNavigator = createStackNavigator(
  {
    Login: {
      screen: LoginScreen,
      navigationOptions: ({navigation})=>({
        header: null
      })
    },
    Signup: {
      screen: SignupScreen,
      navigationOptions: ({navigation})=>({
        title: 'Sign up',
        headerStyle: {
          backgroundColor: '#293046',
        },
        headerTitleStyle: {
          fontSize: 28,
          fontFamily: 'Ubuntu-Light',
          fontWeight: 'normal',
          flex: 1,
          textAlign: 'center',
          color: 'white'
        },
        headerTintColor: 'white',
        headerTransparent: false,
        headerRight: <View />
      })
    }
  },
  {
    initialRouteName: 'Login'
  }
);

AppContainer = createAppContainer(AppNavigator);

export default class App extends Component{
  render() {
    return (
      <AppContainer/>
    );
  }
}