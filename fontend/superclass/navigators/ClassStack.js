import React from 'react';
import { createStackNavigator } from 'react-navigation';

import { defaultConfig } from '../modules/Common';

import HeaderRightButton from '../views/HeaderRightButton';
import ClassGroupScreen from '../views/ClassGroupScreen';
import ChatScreen from '../views/ChatScreen';
import ClassDetailScreen from '../views/ClassDetailScreen';
import ClassMembersScreen from '../views/ClassMembersScreen';
import AssignmentScreen from '../views/AssignmentScreen';
import CreateAssignmentScreen from '../views/CreateAssignmentScreen';
import RollCallScreen from '../views/RollCallScreen';

import AssignmentStack from './AssignmentStack';


export default ClassStack = createStackNavigator(
    {
        ClassGroupList: ClassGroupScreen,
        GroupChat: ChatScreen,
        ClassDetail: ClassDetailScreen,
        ClassMembers: ClassMembersScreen,
        Assignment: AssignmentScreen,
        CreateAssignment: CreateAssignmentScreen,
        RollCall: RollCallScreen,
        AssignmentDetail: {
            screen: AssignmentStack,
            navigationOptions: ({ navigation }) => ({
                title: navigation.getParam('assignment').title,
                headerRight: <HeaderRightButton icon={{ name: 'more-vert', color: 'white' }} />
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
