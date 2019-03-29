//  React Native module that exposes some Objective-C methods to JavaScript.

#import <Foundation/Foundation.h>
#import <UIKit/UIAlertController.h>
#import <UIKit/UINavigationController.h>
#import "ActivityStarterModule.h"
#import "AppDelegate.h"
#import "ExampleView.h"

@implementation ActivityStarterModule

RCT_EXPORT_MODULE(ActivityStarter);

RCT_EXPORT_METHOD(navigateToExample)
{
    dispatch_async(dispatch_get_main_queue(), ^{
        AppDelegate *appDelegate = (AppDelegate *) [UIApplication sharedApplication].delegate;
        [appDelegate navigateToExampleView];
    });
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

RCT_EXPORT_METHOD(callJavaScript)
{
    AppDelegate *appDelegate = (AppDelegate *) [UIApplication sharedApplication].delegate;
    [appDelegate callJavaScript];
}

@end
