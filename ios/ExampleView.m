//
//  ExampleViewController.m
//  Activity
//
//  Created by Petter Hesselberg on 27/03/2019.
//  Copyright © 2019 Facebook. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <React/RCTBridge.h>
#import <UIKit/UINavigationController.h>

#import "AppDelegate.h"
#import "EventEmitter.h"
#import "ExampleView.h"

@implementation ExampleView

- (IBAction)handleGoBackButton:(id)sender {
  AppDelegate *appDelegate = (AppDelegate *) [UIApplication sharedApplication].delegate;
  [appDelegate navigateBack];
}

- (IBAction)handleTriggerEvent:(id)sender {
  AppDelegate *appDelegate = (AppDelegate *) [UIApplication sharedApplication].delegate;
  RCTBridge *reactBridge = [appDelegate reactBridge];
  EventEmitter *eventEmitter = [reactBridge moduleForName:@"EventEmitter"];
  [eventEmitter emitEvent:@"Hello from iOS!"];
}

- (IBAction)handleCallJavaScript:(id)sender {
  AppDelegate *appDelegate = (AppDelegate *) [UIApplication sharedApplication].delegate;
  [appDelegate callJavaScript];
}

@end
