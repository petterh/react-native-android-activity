//
//  EventEmitter.m
//  Activity
//
//  Created by Petter Hesselberg on 28/03/2019.
//  Copyright © 2019 Facebook. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "EventEmitter.h"

@implementation EventEmitter

RCT_EXPORT_MODULE(EventEmitter)

/*! @brief Required because we export constantsToExport */
+ (BOOL) requiresMainQueueSetup
{
  return NO;
}

- (NSDictionary<NSString *, id> *) constantsToExport
{
  return @{@"MyEventName": @"MyEventValue"};
}

- (NSArray <NSString *> *) supportedEvents
{
  return @[@"MyEventValue"];
}

- (void) emitEvent:(NSString *) message
{
  [self sendEventWithName:@"MyEventValue" body:message];
}

@end
