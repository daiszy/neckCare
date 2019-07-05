jQuery(function ($) {
    $.supersized({

        // Functionality
        slide_interval: 4000,    // 图片滑动间隔时间
        transition: 1,    // 转场效果 0-无, 1-Fade, 2-Slide Top, 3-Slide Right, 4-Slide Bottom, 5-Slide Left, 6-Carousel
        // Right, 7-Carousel Left
        transition_speed: 2000,    // 转场速度
        performance: 1,    // 0-Normal, 1-Hybrid speed/quality, 2-Optimizes image quality, 3-Optimizes transition
        // speed // (Only works for Firefox/IE, not Webkit)

        // Size & Position
        min_width: 0,    // 允许最小宽度（像素）
        min_height: 0,    // 允许最小宽度（像素）
        vertical_center: 1,    // 垂直方向居中背景图片
        horizontal_center: 1,    // 水平方向居中背景图片
        fit_always: 0,    // 图像永远不会超过浏览器的宽度或高度(忽略最小尺寸)
        fit_portrait: 1,    // 肖像图像不会超过浏览器的高度
        fit_landscape: 0,    // 景观图像不会超过浏览器的宽度
        random:1,

        // Components
        slide_links: 'blank',    // Individual links for each slide (Options: false, 'num', 'name', 'blank')
        slides: [    // Slideshow Images
            {image: 'assets/img/backgrounds/1.jpg'},
            {image: 'assets/img/backgrounds/2.jpg'},
            {image: 'assets/img/backgrounds/3.jpg'},
            {image: 'assets/img/backgrounds/4.jpg'},
            {image: 'assets/img/backgrounds/5.jpg'},
            {image: 'assets/img/backgrounds/6.jpg'},
        ]

    });

});
