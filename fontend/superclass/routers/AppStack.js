import React from 'react';
import MaterialCommunityIcons from 'react-native-vector-icons/MaterialCommunityIcons';
import { createBottomTabNavigator } from 'react-navigation';

import { Profile } from '../screens';

import ClassStack from './ClassStack';
import CourseTableStack from './CourseTableStack';

export default AppStack = createBottomTabNavigator(
  {
    ClassGroup: {
      screen: ClassStack,
      navigationOptions: {
        title: '班级'
      }
    },
    CourseTable: {
      screen: CourseTableStack,
      navigationOptions: {
        title: '课程表'
      }
    },
    Profile: {
      screen: Profile,
      navigationOptions: {
        title: '我的'
      }
    }
  },
  {
    swipeEnabled: true,
    animationEnabled: true,
    defaultNavigationOptions: ({ navigation }) => ({
      tabBarIcon: ({ focused, tintColor }) => {
        const { routeName } = navigation.state;
        let iconName;
        if (routeName === 'ClassGroup') {
          iconName = `account-multiple${focused ? '' : '-outline'}`;
        } else if (routeName === 'CourseTable') {
          iconName = `calendar${focused ? '' : '-blank'}`;
        } else if (routeName === 'Profile') {
          iconName = `account${focused ? '' : '-outline'}`;
        }

        return <MaterialCommunityIcons name={iconName} size={25} color={tintColor} />
      },
    }),
    tabBarOptions: {
      activeTintColor: '#03A9F4',
      inactiveTintColor: '#9E9E9E'
    }
  }
);