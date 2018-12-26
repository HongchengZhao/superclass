import React, { Component } from 'react'
import { View, StyleSheet, ScrollView, Dimensions, Image, TextInput } from 'react-native'
import { Text, Card, Button, Avatar, Overlay } from 'react-native-elements'
import CountDown from 'react-native-countdown-component'

const SCREEN_WIDTH = Dimensions.get('window').width;
const SCREEN_HEIGHT = Dimensions.get('window').height;

export default class RollCallScreen extends Component {
  static navigationOptions = ({ navigation }) => ({
    title: '签到'
  })

  constructor() {
    super()

    this.state = {
      isAlertVisible: false,
      isSigninBtnDisabled: false
    }
  }

  render() {
    return (
      <View style={styles.container}>
        <ScrollView
          showsVerticalScrollIndicator={false}
        >
          <View style={styles.countdownBg}>
            <Text h3 fontFamily={'Montserrat-Light'} style={{ marginTop: 10, color: 'white' }}>距离签到结束还有</Text>
            <CountDown
              until={60 * 10 + 30}
              size={30}
              digitBgColor={'#fff'}
              digitTxtColor={'#1CC625'}
              timeToShow={['M', 'S']}
              labelM={'分'}
              labelS={'秒'}
              style={styles.countDown}
            />
          </View>
          <View style={{ height: 60, backgroundColor: '#fafafa', zIndex: -999 }}></View>

          <Card
            title={
              <Text
                style={styles.listTitle}
              >已签到成员</Text>
            }
            containerStyle={styles.signedInList}>
            {
              students.map((u, i) => {
                return (
                  <View key={i} style={styles.user}>
                    <Avatar
                      size="medium"
                      rounded
                      source={{ uri: u.avatar_url }}
                      activeOpacity={0.7}
                      ImageComponent={() => <Image />}
                    />
                    <Text style={styles.name}>{u.name}</Text>
                  </View>
                );
              })
            }
          </Card>
        </ScrollView>
        <Button
          title={this.state.isSigninBtnDisabled ? '已签到' : '立即签到'}
          disabled={this.state.isSigninBtnDisabled}
          disabledStyle={styles.disbledBtn}
          containerStyle={styles.signInContainer}
          buttonStyle={styles.signInBtn}
          titleStyle={this.state.isSigninBtnDisabled ? { color: '#666' } : {}}
          onPress={() => {
            this.setState({ isAlertVisible: true, isSigninBtnDisabled: true })
            //setTimeout(() => this.setState({ isAlertVisible: false }), 2000)
          }}
        />
        {
          this.state.isAlertVisible &&
          <Overlay
            isVisible={true}
            containerStyle={{justifyContent:'flex-start', alignItems: 'center'}}
            overlayStyle={{justifyContent:'center', alignItems: 'center', height: 200, margin: 90}}
            onBackdropPress={()=>this.setState({isAlertVisible: false})}
          >
            <Text style={{marginVertical: 10,marginHorizontal: 5,fontSize: 16}}>请输入4位签到码:</Text>
            <View style={styles.signinCodeWrapper}>
              <TextInput
                maxLength={1}
                keyboardType={'numeric'}
                underlineColorAndroid={'rgba(0, 0, 0, 0)'}
                numberOfLines={1}
                style={styles.signinCode}
              />
              <TextInput
                maxLength={1}
                keyboardType={'numeric'}
                underlineColorAndroid={'rgba(0, 0, 0, 0)'}
                numberOfLines={1}
                style={styles.signinCode}
              />
              <TextInput
                maxLength={1}
                keyboardType={'numeric'}
                underlineColorAndroid={'rgba(0, 0, 0, 0)'}
                numberOfLines={1}
                style={styles.signinCode}
              />
              <TextInput
                maxLength={1}
                keyboardType={'numeric'}
                underlineColorAndroid={'rgba(0, 0, 0, 0)'}
                numberOfLines={1}
                style={styles.signinCode}
              />
            </View>
            <Button
              clear
              title='签到'
              containerStyle={{
                margin: 30,
                width: 200,
                backgroundColor: '#8BC34A'
              }}
            />
          </Overlay>
        }
      </View>
    )
  }
}


const styles = StyleSheet.create({
  container: {
    flex: 1,
    flexDirection: 'column',
    justifyContent: 'center',
    alignItems: 'center'
  },
  countdownBg: {
    height: 100,
    backgroundColor: '#2196F3',
    justifyContent: 'flex-start',
    alignItems: 'center',
  },
  countDown: {
    position: 'absolute',
    bottom: -60
  },
  signedInList: {
    margin: 0,
    borderWidth: 0,
    width: SCREEN_WIDTH,
    padding: 10
  },
  listTitle: {
    fontSize: 16,
    fontWeight: '200',
    color: '#aaa',
    borderBottomWidth: 1,
    borderBottomColor: '#eee',
    paddingBottom: 10
  },
  user: {
    width: '100%',
    flexDirection: 'row',
    padding: 5,
    alignItems: 'center'
  },
  image: {
    width: 40,
    height: 40,
  },
  name: {
    paddingLeft: 10,
    fontSize: 18,
    height: '100%',
    width: '100%',
    lineHeight: 50,
    color: '#666'
  },
  signInContainer: {
    position: 'absolute',
    bottom: 0,
    left: 0,
    width: '100%',
    height: 50,
    padding: 5,
    borderTopWidth: 1,
    borderTopColor: '#eee',
    backgroundColor: '#fafafa',
    alignItems: 'center',
    justifyContent: 'center'
  },
  signInBtn: {
    width: '100%',
    backgroundColor: '#f44336',
    elevation: 0,
    shadowOpacity: 0,
    shadowColor: 'transparent'
  },
  disbledBtn: {
    backgroundColor: 'transparent',
    backfaceVisibility: 'hidden'
  },
  signinCode: {
    flex: 1,
    width: 50,
    height: 50,
    borderWidth: 1,
    marginHorizontal: 2,
    borderColor: '#ccc',
    textAlign: 'center'
  },
  signinCodeWrapper: {
    flexDirection: 'row',
  }
})


const students = [
  {
    _id: 3,
    name: 'lostcute',
    avatar_url: 'http://www.jituwang.com/uploads/allimg/150922/258230-150922221K447.jpg'
  },
  {
    _id: 4,
    name: 'yuzu',
    avatar_url: 'http://www.jituwang.com/uploads/allimg/150922/258230-150922221K447.jpg'
  },
  {
    _id: 4,
    name: 'yuzu',
    avatar_url: 'http://www.jituwang.com/uploads/allimg/150922/258230-150922221K447.jpg'
  },
  {
    _id: 4,
    name: 'yuzu',
    avatar_url: 'http://www.jituwang.com/uploads/allimg/150922/258230-150922221K447.jpg'
  },
  {
    _id: 4,
    name: 'yuzu',
    avatar_url: 'http://www.jituwang.com/uploads/allimg/150922/258230-150922221K447.jpg'
  },
  {
    _id: 4,
    name: 'yuzu',
    avatar_url: 'http://www.jituwang.com/uploads/allimg/150922/258230-150922221K447.jpg'
  },
  {
    _id: 4,
    name: 'yuzu',
    avatar_url: 'http://www.jituwang.com/uploads/allimg/150922/258230-150922221K447.jpg'
  },
  {
    _id: 3,
    name: 'lostcute',
    avatar_url: 'http://www.jituwang.com/uploads/allimg/150922/258230-150922221K447.jpg'
  },
  {
    _id: 3,
    name: 'lostcute',
    avatar_url: 'http://www.jituwang.com/uploads/allimg/150922/258230-150922221K447.jpg'
  },
  {
    _id: 3,
    name: 'lostcute',
    avatar_url: 'http://www.jituwang.com/uploads/allimg/150922/258230-150922221K447.jpg'
  },
  {
    _id: 3,
    name: 'lostcute',
    avatar_url: 'http://www.jituwang.com/uploads/allimg/150922/258230-150922221K447.jpg'
  },
]