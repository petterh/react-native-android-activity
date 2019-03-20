/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 */

import React, { Component } from 'react';

import {
  AppRegistry,
  Button,
  NativeEventEmitter,
  NativeModules,
  StyleSheet,
  Text,
  TextInput,
  View
} from 'react-native';

import BatchedBridge from "react-native/Libraries/BatchedBridge/BatchedBridge";

export class ExposedToJava {
  extraMessage = "Be aware that this way of calling JavaScript is officially undocumented.\n\nIf possible, use events instead!";

  setMessage(message) {
    this.extraMessage = message;
  }

  /**
   * If this is called from an activity that doesn't forward Android life-cycle events
   * to React Native, the alert will appear to do nothing.
   */
  alert(message) {
      alert(message + "\n\n" + this.extraMessage);
  }
}

const exposedToJava = new ExposedToJava();
BatchedBridge.registerCallableModule("JavaScriptVisibleToJava", exposedToJava);

const activityStarter = NativeModules.ActivityStarter;

export default class ActivityDemoComponent extends Component {
  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.welcome}>
          Welcome to React Native!
        </Text>
        <Text style={styles.instructions}>
          <Text>To get started, edit </Text>
          <Text style={styles.bold}>index.android.js</Text>
          <Text>.</Text>
        </Text>
        <Text style={styles.instructions}>
          Double tap R on your keyboard to reload,{'\n'}
          Shake or press menu button for dev menu
        </Text>
        <TextInput
          style={styles.textInput}
          value='Demo text for custom edit menu'
        />
        <View style={styles.buttonContainer}>
          <Button
            onPress={() => activityStarter.navigateToExample()}
            title='Start example activity'
          />
          <Button
            onPress={() => activityStarter.dialNumber('+1 (234) 567-8910')}
            title='Dial +1 (234) 567-8910'
          />
          <Button
            onPress={() => activityStarter.getActivityName((name) => { alert(name); })}
            title='Get activity name'
          />
          <Button
            onPress={async () => {
              try {
                var name = await activityStarter.getActivityNameAsPromise();
                alert(name);
              } catch (e) {
                alert("Error: " + e.message);
              }
            }}
            title='Get activity name as promise'
          />
          <Button
            onPress={() => NativeModules.Clipboard.setString("Copied to clipboard from JavaScript!")}
            title='Copy to clipboard'
          />
          <Button
            onPress={() => activityStarter.callJavaScript()}
            title='Call JavaScript from Java'
          />
        </View>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  bold: {
    fontWeight: "bold",
  },
  buttonContainer: {
    height: 300,
    width: "80%",
    justifyContent: 'space-between',
    marginTop: 30,
  },
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#E5ECFF',
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
  textInput: {
    backgroundColor: 'white',
    borderColor: 'gray',
    borderWidth: 1,
    height: 40,
    marginTop: 20,
    textAlign: "center",
    width: "80%",
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
});

AppRegistry.registerComponent('ActivityDemoComponent', () => ActivityDemoComponent);

const eventEmitter = new NativeEventEmitter(activityStarter);
eventEmitter.addListener(activityStarter.MyEventName, (params) => alert(params));
