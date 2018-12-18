import React, { Component } from 'react';
import {
  createStackNavigator,
  createSwitchNavigator,
  createBottomTabNavigator,
  createAppContainer
} from 'react-navigation';
import MaterialCommunityIcons from 'react-native-vector-icons/MaterialCommunityIcons';
import AuthLoadingScreen from './views/AuthLoadingScreen';
import LoginScreen from './views/LoginScreen';
import SignupScreen from './views/SignupScreen';
import TimetableScreen from './views/TimetableScreen';
import UserInfoScreen from './views/UserInfoScreen';
import ClassGroupScreen from './views/ClassGroupScreen';
import ChatScreen from './views/ChatScreen';
import ClassDetailScreen from './views/ClassDetailScreen';
import ClassMembersScreen from './views/ClassMembersScreen';

const ClassStack = createStackNavigator(
  {
    ClassGroupList: ClassGroupScreen,
    GroupChat: ChatScreen,
    ClassDetail: ClassDetailScreen,
    ClassMembers: ClassMembersScreen
  },
  {
    initialRouteName: 'ClassGroupList',
    headerMode: 'float',
    headerTransitionPreset: 'uikit',
    headerLayoutPreset: 'center',
    defaultNavigationOptions: () => defaultConfig
  }
);

ClassStack.navigationOptions = ({ navigation }) => ({
  tabBarVisible: !navigation.state.index
});


const AppStack = createBottomTabNavigator(
  {
    ClassGroup: {
      screen: ClassStack,
      navigationOptions: {
        title: 'Class'
      }
    },
    Timetable: {
      screen: TimetableScreen,
      navigationOptions: {
        title: 'Timetable'
      }
    },
    UserInfo: {
      screen: UserInfoScreen,
      navigationOptions: {
        title: 'User'
      }
    }
  },
  {
    defaultNavigationOptions: ({ navigation }) => ({
      tabBarIcon: ({ focused, tintColor }) => {
        const { routeName } = navigation.state;
        let iconName;
        if (routeName === 'ClassGroup') {
          iconName = `account-multiple${focused ? '' : '-outline'}`;
        } else if (routeName === 'Timetable') {
          iconName = `calendar${focused ? '' : '-blank'}`;
        } else if (routeName === 'UserInfo') {
          iconName = `account${focused ? '' : '-outline'}`;
        }

        return <MaterialCommunityIcons name={iconName} size={25} color={tintColor} />
      },
    }),
    tabBarOptions: {
      activeTintColor: 'tomato',
      inactiveTintColor: 'gray',
    }
  }
);

const AuthStack = createStackNavigator(
  {
    Login: LoginScreen,
    Signup: SignupScreen
  },
  {
    initialRouteName: 'Login',
    headerLayoutPreset: 'center',
    defaultNavigationOptions: () => defaultConfig
  }
);

const AppNavigator = createAppContainer(createSwitchNavigator(
  {
    AuthLoading: AuthLoadingScreen,
    App: AppStack,
    Auth: AuthStack,
  },
  {
    initialRouteName: 'AuthLoading',
  }
));

AppContainer = createAppContainer(AppNavigator);

export default class App extends Component {
  render() {
    return (
      <AppContainer />
    );
  }
}

const defaultConfig = {
  headerStyle: {
    backgroundColor: '#f4511e'
  },
  headerTintColor: '#fff',
  headerTitleStyle: {
    fontFamily: 'Ubuntu-Light',
    fontWeight: 'normal',
    color: 'white'
  }
};