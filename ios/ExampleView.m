// A view controller that we start from JavaScript.

#import <Foundation/Foundation.h>
#import <React/RCTBridge.h>
#import <UIKit/UINavigationController.h>

#import "AppDelegate.h"
#import "EventEmitter.h"
#import "ExampleView.h"

@implementation ExampleView

- (AppDelegate *) appDelegate
{
  return (AppDelegate *) [UIApplication sharedApplication].delegate;
}

- (IBAction)handleGoBackButton:(id)sender {
  [self.appDelegate navigateBack];
}

- (IBAction)handleTriggerEvent:(id)sender {
  RCTBridge *reactBridge = [self.appDelegate reactBridge];
  EventEmitter *eventEmitter = [reactBridge moduleForName:@"EventEmitter"];
  [eventEmitter emitEvent:@"Hello from iOS event emitter!"];
}

- (IBAction)handleCallJavaScript:(id)sender {
  [self.appDelegate callJavaScript];
}

@end
