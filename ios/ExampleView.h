//
//  ExampleViewController.h
//  Activity
//
//  Created by Petter Hesselberg on 27/03/2019.
//  Copyright © 2019 Facebook. All rights reserved.
//

#ifndef ExampleViewController_h
#define ExampleViewController_h

#include <UIKit/UIViewController.h>

@interface ExampleView : UIViewController

@property (weak, nonatomic) IBOutlet UIButton *goBackButton;
@property (weak, nonatomic) IBOutlet UIButton *triggerEventButton;
@property (weak, nonatomic) IBOutlet UIButton *callJavaScriptButton;

@end

#endif /* ExampleViewController_h */
