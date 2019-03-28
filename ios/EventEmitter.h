#ifndef EventEmitter_h
#define EventEmitter_h

#import <React/RCTEventEmitter.h>

@interface EventEmitter : RCTEventEmitter <RCTBridgeModule>

- (void) emitEvent:(NSString *) message;

@end

#endif /* EventEmitter_h */
