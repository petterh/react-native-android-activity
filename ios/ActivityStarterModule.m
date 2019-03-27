//
//  ActivityStarterModule.m
//  Activity
//
//  Created by Petter Hesselberg on 26/03/2019.
//  Copyright © 2019 Facebook. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <UIKit/UIAlertController.h>
#import "ActivityStarterModule.h"

@implementation ActivityStarterModule

RCT_EXPORT_MODULE(ActivityStarter);

RCT_EXPORT_METHOD(navigateToExample)
{
  UIAlertController *alert = [UIAlertController alertControllerWithTitle:@"Hello world"
                                                                 message:@"Message"
                                                          preferredStyle:UIAlertControllerStyleAlert];

  UIAlertAction *defaultAction = [UIAlertAction actionWithTitle:@"OK"
                                                          style:UIAlertActionStyleDefault
                                                        handler:^(UIAlertAction *_Nonnull action) {}];
  [alert addAction:defaultAction];
}

RCT_EXPORT_METHOD(dialNumber:(NSString *) number)
{
#ifdef TARGET_IPHONE_SIMULATOR
  NSLog(@"Cannot dial on simulator");
#else
  NSString *url = [@"tel://" stringByAppendingString:number];
  dispatch_async(dispatch_get_main_queue(), ^{
    BOOL success = [[UIApplication sharedApplication] openURL:[NSURL URLWithString:url]];
    NSLog(@"Open phone URL: %s", success ? "YES" : "NO");
  });
#endif
}

RCT_EXPORT_METHOD(getActivityName:(RCTResponseSenderBlock) callback)
{
  callback(@[@"ActivityStarter (callback)"]);
}

RCT_REMAP_METHOD(getActivityNameAsPromise,
                   getActivityNameAsPromiseWithResolver:(RCTPromiseResolveBlock)resolve
                   rejecter:(RCTPromiseRejectBlock)reject)
{
  resolve(@[@"ActivityStarter (promise)"]);
}

@end
