import React, { Component } from 'react';
import { createSwitchNavigator, createAppContainer } from 'react-navigation';
import AppStack from './navigators/AppStack';
import AuthStack from './navigators/AuthStack';
import AuthLoadingScreen from './views/AuthLoadingScreen';


const AppContainer = createAppContainer(createSwitchNavigator(
  {
    AuthLoading: AuthLoadingScreen,
    App: AppStack,
    Auth: AuthStack,
  }
));

export default class App extends Component {
  render() {
    return <AppContainer />;
  }
}