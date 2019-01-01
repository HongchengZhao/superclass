import React from 'react';
import { createStackNavigator } from 'react-navigation';

import { defaultConfig } from '../modules/Common';

import { CourseTable, ImportCourse } from '../screens';

const CourseTableStack = createStackNavigator(
    {
        CourseTableView: CourseTable,
        ImportCourse: ImportCourse
    },
    {
        initialRouteName: 'CourseTableView',
        headerMode: 'float',
        headerTransitionPreset: 'uikit',
        headerLayoutPreset: 'center',
        defaultNavigationOptions: () => defaultConfig
    }
)

CourseTableStack.navigationOptions = ({ navigation }) => ({
    tabBarVisible: !navigation.state.index
});

export default CourseTableStack;