import React, { Component } from 'react';
import { Platform, StyleSheet, Text, View, StatusBar, Dimensions, AsyncStorage } from 'react-native';
import { Input, Button } from 'react-native-elements';
import { WebView } from "react-native-webview";
import Icon from 'react-native-vector-icons/AntDesign';

const SCREEN_WIDTH = Dimensions.get('window').width;
const SCREEN_HEIGHT = Dimensions.get('window').height;
const BG_IMAGE = require('../assets/images/bg_screen1.jpg');
const BG_HTML = require('../assets/pages/background.html');

export default class LoginScreen extends Component {
  static navigationOptions = ({ navigation }) => ({
    header: null
  })

  constructor(props) {
    super(props);

    this.state = {
      fontLoaded: false,
      email: '',
      email_valid: true,
      password: '',
      login_failed: false,
      showLoading: false
    };
  }

  async componentDidMount() {

  }

  validateEmail(email) {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

    return re.test(email);
  }

  submitLoginCredentials() {
    /*
    const { showLoading } = this.state;

    this.setState({
      showLoading: !showLoading
    });
    */
    this.props.navigation.navigate('App');
  }

  render() {
    const { email, password, email_valid, showLoading } = this.state;
    baseURL = Platform.OS == 'android' ? 'file:///android_asset/pages/' : './external/pages/';

    return (
      <View style={styles.container}>

        <StatusBar backgroundColor='#2196F3' />

        <WebView
          source={{
            uri: baseURL + 'background.html',
            baseUrl: baseURL
          }}
          style={styles.bgImage}
        />

        <View style={styles.loginView}>
          <View style={styles.loginTitle}>
            <View style={{ flexDirection: 'row' }}>
              <Text style={styles.travelText}>TRAVEL</Text>
              <Text style={styles.plusText}>+</Text>
            </View>
            <View style={{ marginTop: -10 }}>
              <Text style={styles.travelText}>LEISURE</Text>
            </View>
          </View>
          <View style={styles.loginInput}>
            <Input
              leftIcon={
                <Icon
                  name='user'
                  color='rgba(171, 189, 219, 1)'
                  size={25}
                />
              }
              containerStyle={{ marginVertical: 10 }}
              onChangeText={email => this.setState({ email })}
              value={email}
              inputStyle={{ marginLeft: 10, color: 'white' }}
              keyboardAppearance="light"
              placeholder="Email"
              autoFocus={false}
              autoCapitalize="none"
              autoCorrect={false}
              keyboardType="email-address"
              returnKeyType="next"
              ref={input => this.emailInput = input}
              onSubmitEditing={() => {
                this.setState({ email_valid: this.validateEmail(email) });
                this.passwordInput.focus();
              }}
              blurOnSubmit={false}
              placeholderTextColor="white"
              errorStyle={{ textAlign: 'center', fontSize: 12 }}
              errorMessage={email_valid ? null : "Please enter a valid email address"}
            />
            <Input
              leftIcon={
                <Icon
                  name='lock'
                  color='rgba(171, 189, 219, 1)'
                  size={25}
                />
              }
              containerStyle={{ marginVertical: 10 }}
              onChangeText={(password) => this.setState({ password })}
              value={password}
              inputStyle={{ marginLeft: 10, color: 'white' }}
              secureTextEntry={true}
              keyboardAppearance="light"
              placeholder="Password"
              autoCapitalize="none"
              autoCorrect={false}
              keyboardType="default"
              returnKeyType="done"
              ref={input => this.passwordInput = input}
              blurOnSubmit={true}
              placeholderTextColor="white"
            />
          </View>
          <Button
            clear
            title='LOG IN'
            activeOpacity={1}
            underlayColor="transparent"
            onPress={this.submitLoginCredentials.bind(this)}
            loading={showLoading}
            loadingProps={{ size: 'small', color: 'white' }}
            disabled={!email_valid && password.length < 8}
            buttonStyle={styles.loginBtn}
            containerStyle={{ marginVertical: 10, backgroundColor: 'rgba(255, 255, 255, 0.1)', borderRadius: 30 }}
            titleStyle={{ fontWeight: 'bold', color: 'white' }}
          />
          <View style={styles.footerView}>
            <Text style={{ color: 'grey' }}>New here?</Text>
            <Button
              title="Create an Account"
              clear
              activeOpacity={0.5}
              titleStyle={{ color: 'white', fontSize: 15 }}
              containerStyle={{ marginTop: -10 }}
              onPress={() => this.props.navigation.navigate('Signup')}
            />
          </View>

        </View>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    flexDirection: 'column',
    justifyContent: 'center'
  },
  bgImage: {
    flex: 1,
    width: SCREEN_WIDTH,
    height: SCREEN_HEIGHT,
    position: 'absolute',
    top: 0,
    left: 0,
    zIndex: -999,
    backgroundColor: '#2196F3'
  },
  loginBtn: {
    height: 50,
    width: 250,
    borderWidth: 2,
    backgroundColor: 'transparent',
    borderColor: 'white',
    borderRadius: 30
  },
  loginView: {
    flex: 1,
    marginTop: 150,
    width: SCREEN_WIDTH,
    minHeight: 400,
    justifyContent: 'center',
    alignItems: 'center'
  },
  loginTitle: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
  travelText: {
    color: 'white',
    fontSize: 30,
    fontFamily: 'Montserrat-Bold'
  },
  plusText: {
    color: 'white',
    fontSize: 30,
    fontFamily: 'Montserrat-Regular'
  },
  loginInput: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    width: 250
  },
  footerView: {
    marginTop: 20,
    flex: 0.5,
    justifyContent: 'center',
    alignItems: 'center',
  }
});