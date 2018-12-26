import React from 'react';
import MaterialCommunityIcons from 'react-native-vector-icons/MaterialCommunityIcons';
import { createBottomTabNavigator} from 'react-navigation';
import TimetableScreen from '../views/TimetableScreen';
import UserInfoScreen from '../views/UserInfoScreen';
import ClassStack from './ClassStack';


export default AppStack = createBottomTabNavigator(
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
    swipeEnabled: true,
    animationEnabled: true,
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
      activeTintColor: '#03A9F4',
      inactiveTintColor: '#9E9E9E'
    }
  }
);