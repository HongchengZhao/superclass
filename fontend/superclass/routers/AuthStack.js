import { createStackNavigator } from 'react-navigation';

import defaultConfig from '../modules/Common';
import { Login, Signup } from '../screens';

export default AuthStack = createStackNavigator(
    {
        Login: Login,
        Signup: Signup
    },
    {
        initialRouteName: 'Login',
        headerLayoutPreset: 'center',
        defaultNavigationOptions: () => defaultConfig
    }
);