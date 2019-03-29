#import <UIKit/UIKit.h>
#import <React/RCTBridgeDelegate.h>

@interface AppDelegate : UIResponder <UIApplicationDelegate, RCTBridgeDelegate>

@property (nonatomic, strong) UIWindow *window;
@property (nonatomic, strong) RCTBridge *reactBridge;

- (void) navigateToExampleView;
- (void) navigateBack;
- (void) callJavaScript;

@end
