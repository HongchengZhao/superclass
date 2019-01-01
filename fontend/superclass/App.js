import React, { Component } from 'react';
import { createSwitchNavigator, createAppContainer } from 'react-navigation';
import AppStack from './routers/AppStack';
import AuthStack from './routers/AuthStack';
import { AuthLoading } from './screens';

const AppContainer = createAppContainer(createSwitchNavigator(
  {
    AuthLoading: AuthLoading,
    App: AppStack,
    Auth: AuthStack,
  }
));

export default class App extends Component {
  render() {
    return <AppContainer />;
  }
}