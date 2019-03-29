#ifndef ExampleViewController_h
#define ExampleViewController_h

#include <UIKit/UIViewController.h>

@interface ExampleView : UIViewController

@property (weak, nonatomic) IBOutlet UIButton *goBackButton;
@property (weak, nonatomic) IBOutlet UIButton *triggerEventButton;
@property (weak, nonatomic) IBOutlet UIButton *callJavaScriptButton;

@end

#endif /* ExampleViewController_h */
