/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 */

import React, { Component } from 'react';

import {
  AppRegistry,
  Button,
  NativeModules,
  StyleSheet,
  Text,
  View
} from 'react-native';

import BatchedBridge from "react-native/Libraries/BatchedBridge/BatchedBridge";

export class ExposedToJava {
  alert(message) {
      alert(message);
  }
}

const exposedToJava = new ExposedToJava();
BatchedBridge.registerCallableModule("JavaScriptVisibleToJava", exposedToJava);

export default class ActivityDemoComponent extends Component {
  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.welcome}>
          Welcome to React Native!
        </Text>
        <Text style={styles.instructions}>
          To get started, edit index.android.js
        </Text>
        <Text style={styles.instructions}>
          Double tap R on your keyboard to reload,{'\n'}
          Shake or press menu button for dev menu
        </Text>
        <View style={styles.buttonContainer}>
          <Button
            onPress={() => NativeModules.ActivityStarter.navigateToExample()}
            title='Start example activity'
          />
          <Button
            onPress={() => NativeModules.ActivityStarter.dialNumber('+1 (234) 567-8910')}
            title='Dial +1 (234) 567-8910'
          />
          <Button
            onPress={() => NativeModules.ActivityStarter.getActivityName((name) => { alert(name); })}
            title='Get activity name'
          />
          <Button
            onPress={async () => {
              try {
                var name = await NativeModules.ActivityStarter.getActivityNameAsPromise();
                alert(name);
                } catch (e) {
                  alert(e.message);
                }
              }}
            title='Get activity name as promise'
          />
          <Button
            onPress={() => NativeModules.Clipboard.setString("Hello from JavaScript!")}
            title='Copy to clipboard'
          />
          <Button
            onPress={() => NativeModules.ActivityStarter.callJavaScript()}
            title='Call JavaScript from Java'
          />
        </View>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  buttonContainer: {
    height: 300,
    width: 220,
    justifyContent: 'space-between',
    marginTop: 50,
  },
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});

AppRegistry.registerComponent('ActivityDemoComponent', () => ActivityDemoComponent);
