import { createStackNavigator } from 'react-navigation';

import defaultConfig from '../modules/Common';
import LoginScreen from '../views/LoginScreen';
import SignupScreen from '../views/SignupScreen';

export default AuthStack = createStackNavigator(
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