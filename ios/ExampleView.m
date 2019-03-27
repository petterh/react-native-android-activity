//
//  ExampleViewController.m
//  Activity
//
//  Created by Petter Hesselberg on 27/03/2019.
//  Copyright © 2019 Facebook. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <UIKit/UINavigationController.h>

#import "AppDelegate.h"
#import "ExampleView.h"

@implementation ExampleView
{
}

- (IBAction)handleGoBackButton:(id)sender {
  AppDelegate *appDelegate = (AppDelegate *) [UIApplication sharedApplication].delegate;
  [appDelegate navigateBack];
}

- (IBAction)handleTriggerEvent:(id)sender {
}

- (IBAction)handleCallJavaScript:(id)sender {
}

@end
