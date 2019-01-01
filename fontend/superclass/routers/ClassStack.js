import React from 'react';
import { createStackNavigator } from 'react-navigation';

import { defaultConfig } from '../modules/Common';

import { HeaderButton } from '../components';
import {
  ClassGroup,
  Chat,
  ClassDetail,
  ClassMembers,
  Assignment,
  CreateAssignment,
  RollCall
} from '../screens';

import AssignmentStack from './AssignmentStack';


export default ClassStack = createStackNavigator(
    {
        ClassGroupList: ClassGroup,
        GroupChat: Chat,
        ClassDetail: ClassDetail,
        ClassMembers: ClassMembers,
        Assignment: Assignment,
        CreateAssignment: CreateAssignment,
        RollCall: RollCall,
        AssignmentDetail: {
            screen: AssignmentStack,
            navigationOptions: ({ navigation }) => ({
                title: navigation.getParam('assignment').title,
                headerRight: <HeaderButton icon={{ name: 'more-vert', color: 'white' }} />
            })
        }
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
