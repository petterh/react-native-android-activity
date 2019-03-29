// React Native module that lets Objective-C send events to JavaScript.

#import <Foundation/Foundation.h>
#import "EventEmitter.h"

@implementation EventEmitter
{
    BOOL hasObservers; // This is purely a performance thing
}

RCT_EXPORT_MODULE(EventEmitter)

/*! @brief Required because we export constantsToExport */
+ (BOOL) requiresMainQueueSetup
{
    return YES;
}

/*!
 * Allows us to write 'EventEmitter.MyEventName' in JavaScript and get 'MyEventValue.
 * Hardcoding 'MyEventValue' in JavaScript would have the same effect.
 */
- (NSDictionary<NSString *, id> *) constantsToExport
{
    return @{@"MyEventName": @"MyEventValue"};
}

- (NSArray <NSString *> *) supportedEvents
{
    return @[@"MyEventValue"];
}

- (void) startObserving
{
    hasObservers = YES;
}

- (void) stopObserving
{
    hasObservers = NO;
}

- (void) emitEvent:(NSString *) message
{
    if (hasObservers) {
        [self sendEventWithName:@"MyEventValue" body:message];
    }
}

@end
