import { createMaterialTopTabNavigator } from 'react-navigation';
import { AssignmentDetail, Submission } from '../screens';

export default AssignmentStack = createMaterialTopTabNavigator(
    {
        AssignmentDetail:  AssignmentDetail,
        Submission: Submission
    },
    {
        swipeEnabled: false,
        animationEnabled: true,
        lazy: true,
        tabBarOptions: {
            activeTintColor: 'rgba(33, 150, 243, 1)',
            inactiveTintColor: 'rgba(33, 150, 243, 0.7)',
            upperCaseLabel: false,
            pressColor: 'transparent',
            pressOpacity: 1,
            style: {
                elevation: 0,
                shadowOpacity: 0,
                shadowColor: 'transparent',
                shadowRadius: 0,
                backgroundColor: 'transparent',
                borderBottomWidth: 0.5,
                borderBottomColor: '#eee'
            },
            tabStyle: {
                height: 30,
            },
            indicatorStyle: {
                //backgroundColor: 'transparent'
            }
        }
    }
);