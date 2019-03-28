/**
 * Copyright (c) 2015-present, Facebook, Inc.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */

#import <React/RCTBundleURLProvider.h>
#import <React/RCTDevMenu.h>
#import <React/RCTRootView.h>

#import "AppDelegate.h"
#import "ExampleView.h"

@implementation AppDelegate
{
  UINavigationController *navigationController;
}

- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions
{
  self.reactBridge = [[RCTBridge alloc] initWithDelegate:self launchOptions:launchOptions];

  RCTDevMenuItem *devMenuItem = [RCTDevMenuItem buttonItemWithTitle:@"Custom menu item"
                                                            handler:^{
                                                              NSLog(@"Custom menu item clicked!");
                                                            }];
  [self.reactBridge.devMenu addItem:devMenuItem];

  RCTRootView *rootView = [[RCTRootView alloc] initWithBridge:self.reactBridge
                                                   moduleName:@"ActivityDemoComponent"
                                            initialProperties:nil];
  rootView.backgroundColor = [[UIColor alloc] initWithRed:1.0f green:1.0f blue:1.0f alpha:1];

  UIViewController *rootViewController = [UIViewController new];
  rootViewController.view = rootView;
  navigationController = [[UINavigationController alloc] initWithRootViewController:rootViewController];

  self.window = [[UIWindow alloc] initWithFrame:[UIScreen mainScreen].bounds];
  self.window.rootViewController = navigationController;
  [self.window makeKeyAndVisible];

  return YES;
}

- (void) navigateToExampleView
{
  ExampleView *viewController = [[ExampleView alloc] initWithNibName:@"ExampleView" bundle:nil];
  [navigationController pushViewController:viewController animated:YES];
}

- (void) navigateBack
{
  [navigationController popViewControllerAnimated:YES];
}

- (void) callJavaScript
{
  [self.reactBridge enqueueJSCall:@"JavaScriptVisibleToJava"
                           method:@"alert"
                             args:@[@"Hello, JavaScript!"]
                       completion:nil];
}

- (NSURL *)sourceURLForBridge:(RCTBridge *)bridge {
  NSURL *jsCodeLocation = [[RCTBundleURLProvider sharedSettings] jsBundleURLForBundleRoot:@"index.android"
                                                                         fallbackResource:nil];
  return jsCodeLocation;
}

@end
