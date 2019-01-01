import React, { Component } from 'react'
import {
  Alert,
  LayoutAnimation,
  TouchableOpacity,
  Dimensions,
  Image,
  UIManager,
  StyleSheet,
  Text,
  View,
  StatusBar
} from 'react-native'
import { Input, Button } from 'react-native-elements'
import LinearGradient from 'react-native-linear-gradient'
import Icon from 'react-native-vector-icons/SimpleLineIcons'
import { KeyboardAwareScrollView } from 'react-native-keyboard-aware-scroll-view'
import { Header } from 'react-navigation'
import { BASE_URL } from '../modules/Common'

// Enable LayoutAnimation on Android
UIManager.setLayoutAnimationEnabledExperimental &&
  UIManager.setLayoutAnimationEnabledExperimental(true)

const USER_TEACHER = require('../assets/images/user-teacher.png')
const USER_STUDENT = require('../assets/images/user-student.png')

const SCREEN_WIDTH = Dimensions.get('window').width
const SCREEN_HEIGHT = Dimensions.get('window').height

export default class Signup extends Component {
  static navigationOptions = ({ navigation }) => ({
    title: 'Sign up',
    headerStyle: {
      backgroundColor: '#2196F3',
      elevation: 0,
      shadowColor: 'transparent'
    },
    headerTintColor: '#fff',
    headerTitleStyle: {
      color: 'white'
    }
  })


  constructor(props) {
    super(props)

    this.state = {
      isLoading: false,
      selectedType: null,
      username: '',
      phoneNumber: '',
      password: '',
      confirmationPassword: '',
      phoneNumberValid: true,
      passwordValid: true,
      usernameValid: true,
      confirmationPasswordValid: true,
      res: null
    }

    this.setSelectedType = this.setSelectedType.bind(this)
    this.validatePhoneNumber = this.validatePhoneNumber.bind(this)
    this.validatePassword = this.validatePassword.bind(this)
    this.validateConfirmationPassword = this.validateConfirmationPassword.bind(this)
    this.signup = this.signup.bind(this)
  }

  async componentDidMount() {

  }

  signup() {
    LayoutAnimation.easeInEaseOut()
    const usernameValid = this.validateUsername()
    const phoneNumberValid = this.validatePhoneNumber()
    const passwordValid = this.validatePassword()
    const confirmationPasswordValid = this.validateConfirmationPassword()
    if (
      phoneNumberValid &&
      passwordValid &&
      confirmationPasswordValid &&
      usernameValid
    ) {
      this.setState({
        isLoading: true
      })
      /*
      setTimeout(() => {
        LayoutAnimation.easeInEaseOut()
        this.setState({
          isLoading: false
        })
        Alert.alert('🎸', 'You rock')
      }, 1500)
      */
      const {
        username,
        password,
        phoneNumber,
        selectedType
      } = this.state

      fetch(`${BASE_URL}/api/users`, {
        method: 'POST',
        headers: {
          Accept: 'application/json',
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          username: username,
          password: password,
          phoneNumber: phoneNumber,
          isTeacher: selectedType === 'teacher'
        })
      }).then(response => response.json())
        .then(response => this.setState({res: response}))
    }
  }

  validateType(){
    const { selectedType } = this.state
    return selectedType != null
  }

  validateUsername() {
    const {
      username
    } = this.state
    const usernameValid = username.length > 0
    LayoutAnimation.easeInEaseOut()
    this.setState({
      usernameValid
    })
    usernameValid || this.usernameInput.shake()
    return usernameValid
  }

  validatePhoneNumber() {
    const {
      phoneNumber
    } = this.state
    const re = /^1[3|4|5|8][0-9]\d{4,8}$/
    const phoneNumberValid = re.test(phoneNumber)
    LayoutAnimation.easeInEaseOut()
    this.setState({
      phoneNumberValid
    })
    phoneNumberValid || this.phoneNumberInput.shake()
    return phoneNumberValid
  }

  validatePassword() {
    const {
      password
    } = this.state
    const passwordValid = password.length >= 8
    LayoutAnimation.easeInEaseOut()
    this.setState({
      passwordValid
    })
    passwordValid || this.passwordInput.shake()
    return passwordValid
  }

  validateConfirmationPassword() {
    const {
      password,
      confirmationPassword
    } = this.state
    const confirmationPasswordValid = password === confirmationPassword
    LayoutAnimation.easeInEaseOut()
    this.setState({
      confirmationPasswordValid
    })
    confirmationPasswordValid || this.confirmationPasswordInput.shake()
    return confirmationPasswordValid
  }

  setSelectedType = selectedType =>
    LayoutAnimation.easeInEaseOut() || this.setState({
      selectedType
    })

  render() {
    const {
      isLoading,
      selectedType,
      confirmationPassword,
      phoneNumber,
      phoneNumberValid,
      password,
      passwordValid,
      confirmationPasswordValid,
      username,
      usernameValid,
    } = this.state

    return (
      <KeyboardAwareScrollView
        scrollEnabled={true}
        contentContainerStyle={styles.container}
      >
        <StatusBar backgroundColor='#2196F3' />

        <Text style={styles.whoAreYouText}>请选择您的身份</Text>
        <View style={styles.userTypesContainer}>
          <UserTypeItem
            label="学生"
            labelColor="#36717F"
            image={USER_STUDENT}
            onPress={() => this.setSelectedType('student')}
            selected={selectedType === 'student'}
          />
          <UserTypeItem
            label="老师"
            labelColor="#2CA75E"
            image={USER_TEACHER}
            onPress={() => this.setSelectedType('teacher')}
            selected={selectedType === 'teacher'}
          />
        </View>
        <View style={{ width: '80%', alignItems: 'center' }}>
          <FormInput
            refInput={input => (this.usernameInput = input)}
            icon="user"
            value={username}
            onChangeText={username => this.setState({ username })}
            placeholder="用户名"
            returnKeyType="next"
            errorMessage={usernameValid ? null : '用户名不能为空'}
            onSubmitEditing={() => {
              this.validateUsername()
              this.phoneNumberInput.focus()
            }}
          />
          <FormInput
            refInput={input => (this.phoneNumberInput = input)}
            icon="phone"
            value={phoneNumber}
            onChangeText={phoneNumber => this.setState({ phoneNumber })}
            placeholder="电话号码"
            keyboardType="phone-pad"
            returnKeyType="next"
            errorMessage={phoneNumberValid ? null : 'Please enter a valid phoneNumber address'}
            onSubmitEditing={() => {
              this.validatephoneNumber()
              this.passwordInput.focus()
            }}
          />
          <FormInput
            refInput={input => (this.passwordInput = input)}
            icon="lock"
            value={password}
            onChangeText={password => this.setState({ password })}
            placeholder="密码"
            secureTextEntry
            returnKeyType="next"
            errorMessage={passwordValid ? null : '密码至少要8位'}
            onSubmitEditing={() => {
              this.validatePassword()
              this.confirmationPasswordInput.focus()
            }}
          />
          <FormInput
            refInput={input => (this.confirmationPasswordInput = input)}
            icon="lock"
            value={confirmationPassword}
            onChangeText={confirmationPassword =>
              this.setState({ confirmationPassword })}
            placeholder="确认密码"
            secureTextEntry
            errorMessage={confirmationPasswordValid ? null : 'The password fields are not identics'}
            returnKeyType="go"
            onSubmitEditing={() => {
              this.validateConfirmationPassword()
              this.signup()
            }}
          />
        </View>
        <Button
          clear
          ViewComponent={LinearGradient}
          loading={isLoading}
          title="注册"
          containerStyle={{}}
          buttonStyle={styles.signUpButton}
          linearGradientProps={{
            colors: ['#FF9800', '#F44336'],
            start: { x: 1, y: 0 },
            end: { x: 0.2, y: 0 },
          }}
          titleStyle={styles.signUpButtonText}
          onPress={this.signup}
          disabled={isLoading}
        />
        <View style={styles.loginHereContainer}>
          <Text style={styles.alreadyAccountText}>
            已有账户？
            		</Text>
          <Button
            title={this.state.res}
            clear
            titleStyle={styles.loginHereText}
            containerStyle={{ backgroundColor: 'transparent', borderWidth: 0 }}
            buttonStyle={{ backgroundColor: 'transparent', borderWidth: 0 }}
            underlayColor="transparent"
            onPress={() => this.props.navigation.navigate('Login')}
          />
        </View>
        {
          this.state.res &&
            <Text>{this.state.res}</Text>
        }
      </KeyboardAwareScrollView>
    )
  }
}

export const UserTypeItem = props => {
  const {
    image,
    label,
    labelColor,
    selected,
    ...attributes
  } = props
  return (
    <TouchableOpacity {...attributes}>
      <View
        style={[
          styles.userTypeItemContainer,
          selected && styles.userTypeItemContainerSelected,
        ]}
      >
        <Text style={[styles.userTypeLabel, { color: labelColor }]}>
          {label}
        </Text>
        <Image
          source={image}
          style={[
            styles.userTypeMugshot,
            selected && styles.userTypeMugshotSelected,
          ]}
        />
      </View>
    </TouchableOpacity>
  )
}

export const FormInput = props => {
  const {
    icon,
    refInput,
    ...otherProps
  } = props
  return (
    <Input
      {...otherProps}
      ref={refInput}
      inputContainerStyle={styles.inputContainer}
      leftIcon={<Icon name={icon} color="#7384B4" size={18} />}
      inputStyle={styles.inputStyle}
      autoFocus={false}
      autoCapitalize="none"
      keyboardAppearance="dark"
      errorStyle={styles.errorInputStyle}
      autoCorrect={false}
      blurOnSubmit={false}
      placeholderTextColor='#bdc3c7'
    />
  )
}

const styles = StyleSheet.create({
  container: {
    paddingBottom: 20,
    backgroundColor: '#fafafa',
    width: SCREEN_WIDTH,
    height: SCREEN_HEIGHT - Header.HEIGHT,
    alignItems: 'center',
    justifyContent: 'space-around',
  },
  signUpText: {
    color: 'white',
    fontSize: 28,
    fontFamily: 'Ubuntu-Light',
  },
  whoAreYouText: {
    color: '#7384B4',
    fontFamily: 'Ubuntu-Bold',
    fontSize: 14,
  },
  userTypesContainer: {
    flexDirection: 'row',
    justifyContent: 'space-around',
    width: SCREEN_WIDTH,
    alignItems: 'center',
  },
  userTypeItemContainer: {
    alignItems: 'center',
    justifyContent: 'center',
    opacity: 0.5,
  },
  userTypeItemContainerSelected: {
    opacity: 1,
  },
  userTypeMugshot: {
    margin: 4,
    height: 60,
    width: 60,
  },
  userTypeMugshotSelected: {
    height: 80,
    width: 80,
  },
  userTypeLabel: {
    color: 'yellow',
    fontFamily: 'Ubuntu-Bold',
    fontSize: 11,
  },
  inputContainer: {
    paddingLeft: 8,
    borderRadius: 5,
    borderWidth: 1,
    borderColor: 'rgba(110, 120, 170, 1)',
    height: 45,
    marginVertical: 10,
    backgroundColor: '#fafafa'
  },
  inputStyle: {
    flex: 1,
    marginLeft: 10,
    color: '#7384B4',
    fontFamily: 'Ubuntu-Light',
    fontSize: 16,
  },
  errorInputStyle: {
    marginTop: 0,
    textAlign: 'center',
    color: '#F44336',
  },
  signUpButtonText: {
    fontFamily: 'Ubuntu-Bold',
    fontSize: 13,
  },
  signUpButton: {
    width: 250,
    borderRadius: 50,
    height: 45,
  },
  loginHereContainer: {
    flexDirection: 'row',
    alignItems: 'center',
  },
  alreadyAccountText: {
    fontFamily: 'Ubuntu-Light-Italic',
    fontSize: 12,
    color: '#999',
  },
  loginHereText: {
    color: '#FF9800',
    fontFamily: 'Ubuntu-Light-Italic',
    fontSize: 12,
  },
})