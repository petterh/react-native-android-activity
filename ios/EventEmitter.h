//
//  EventEmitter.h
//  Activity
//
//  Created by Petter Hesselberg on 28/03/2019.
//  Copyright © 2019 Facebook. All rights reserved.
//

#ifndef EventEmitter_h
#define EventEmitter_h

#import <React/RCTEventEmitter.h>

@interface EventEmitter : RCTEventEmitter <RCTBridgeModule>

- (void) emitEvent:(NSString *) message;

@end

#endif /* EventEmitter_h */
