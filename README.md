#### 参考链接：

[WebView使用详解（一）——Native与JS相互调用（附JadX反编译）](http://blog.csdn.net/harvic880925/article/details/51464687)

[Android：这是一份全面 & 详细的Webview使用攻略](https://www.jianshu.com/p/3c94ae673e2a)
	
#### 对于加载URL的总结：

1、如果是在线网址记得添加网络访问权限

2、在线网址中，如果要使用webview打开，记得设置WebViewClient，不设置默认使用浏览器打开页面

3、打开本地html文件时，是不需要设置WebViewClient，对应的asstes目录的url为：file:///android_asset/xxxxx

#### 基本设置

通过WebView.getSettings()获取设置WebView的WebSettings对象，然后进行设置

    /**
     * 是否支持缩放，配合方法setBuiltInZoomControls使用，默认true
     */
    setSupportZoom(boolean support)

    /**
     * 是否需要用户手势来播放Media，默认true
     */
    setMediaPlaybackRequiresUserGesture(boolean require)

    /**
     * 是否使用WebView内置的缩放组件，由浮动在窗口上的缩放控制和手势缩放控制组成，默认false
     */
    setBuiltInZoomControls(boolean enabled)

    /**
     * 是否显示窗口悬浮的缩放控制，默认true
     */
    setDisplayZoomControls(boolean enabled)

    /**
     * 是否允许访问WebView内部文件，默认true
     */
    setAllowFileAccess(boolean allow)

    /**
     * 是否允许获取WebView的内容URL ，可以让WebView访问ContentPrivider存储的内容。 默认true
     */
    setAllowContentAccess(boolean allow)

    /**
     * 是否启动概述模式浏览界面，当页面宽度超过WebView显示宽度时，缩小页面适应WebView。默认false
     */
    setLoadWithOverviewMode(boolean overview)

    /**
     * 是否保存表单数据，默认false
     */
    setSaveFormData(boolean save)

    /**
     * 设置页面文字缩放百分比，默认100%
     */
    setTextZoom(int textZoom)

    /**
     * 是否支持ViewPort的meta tag属性，如果页面有ViewPort meta tag 指定的宽度，则使用meta tag指定的值，否则默认使用宽屏的视图窗口
     */
    setUseWideViewPort(boolean use)


    /**
     * 是否支持多窗口，如果设置为true ，WebChromeClient#onCreateWindow方法必须被主程序实现，默认false
     */
    setSupportMultipleWindows(boolean support)

    /**
     * 指定WebView的页面布局显示形式，调用该方法会引起页面重绘。默认LayoutAlgorithm#NARROW_COLUMNS
     */
    setLayoutAlgorithm(LayoutAlgorithm l)

    /**
     * 设置标准的字体族，默认”sans-serif”。font-family 规定元素的字体系列。
     * font-family 可以把多个字体名称作为一个“回退”系统来保存。如果浏览器不支持第一个字体，
     * 则会尝试下一个。也就是说，font-family 属性的值是用于某个元素的字体族名称或/及类族名称的一个
     * 优先表。浏览器会使用它可识别的第一个值。
     */
    setStandardFontFamily(String font)

    /**
     * 设置混合字体族。默认”monospace”
     */
    setFixedFontFamily(String font)

    /**
     * 设置SansSerif字体族。默认”sans-serif”
     */
    setSansSerifFontFamily(String font)

    /**
     * 设置SerifFont字体族，默认”sans-serif”
     */
    setSerifFontFamily(String font)

    /**
     * 设置CursiveFont字体族，默认”cursive”
     */
    setCursiveFontFamily(String font)

    /**
     * 设置FantasyFont字体族，默认”fantasy”
     */
    setFantasyFontFamily(String font)

    /**
     * 设置最小字体，默认8. 取值区间[1-72]，超过范围，使用其上限值。
     */
    setMinimumFontSize(int size)

    /**
     * 设置最小逻辑字体，默认8. 取值区间[1-72]，超过范围，使用其上限值。
     */
    setMinimumLogicalFontSize(int size)

    /**
     * 设置默认字体大小，默认16，取值区间[1-72]，超过范围，使用其上限值。
     */
    setDefaultFontSize(int size)

    /**
     * 设置默认填充字体大小，默认16，取值区间[1-72]，超过范围，使用其上限值。
     */
    setDefaultFixedFontSize(int size)

    /**
     * 设置是否加载图片资源，注意：方法控制所有的资源图片显示，包括嵌入的本地图片资源。
     * 使用方法setBlockNetworkImage则只限制网络资源图片的显示。值设置为true后，
     * webview会自动加载网络图片。默认true
     */
    setLoadsImagesAutomatically(boolean flag)

    /**
     * 是否加载网络图片资源。注意如果getLoadsImagesAutomatically返回false，则该方法没有效果。
     * 如果使用setBlockNetworkLoads设置为false，该方法设置为false，也不会显示网络图片。
     * 当值从true改为false时。WebView会自动加载网络图片。
     */
    setBlockNetworkImage(boolean flag)

    /**
     * 设置是否加载网络资源。注意如果值从true切换为false后，WebView不会自动加载，
     * 除非调用WebView#reload().如果没有android.Manifest.permission#INTERNET权限，
     * 值设为false，则会抛出java.lang.SecurityException异常。
     * 默认值：有android.Manifest.permission#INTERNET权限时为false，其他为true。
     */
    setBlockNetworkLoads(boolean flag)

    /**
     * 设置是否允许执行JS。
     */
    setJavaScriptEnabled(boolean flag)

    /**
     * 是否允许Js访问任何来源的内容。包括访问file scheme的URLs。考虑到安全性，
     * 限制Js访问范围默认禁用。注意：该方法只影响file scheme类型的资源，其他类型资源如图片类型的，
     * 不会受到影响。ICE_CREAM_SANDWICH_MR1版本以及以下默认为true，JELLY_BEAN版本
     * 以上默认为false
     */
    setAllowUniversalAccessFromFileURLs(boolean flag)


    /**
     * 是否允许Js访问其他file scheme的URLs。包括访问file scheme的资源。考虑到安全性，
     * 限制Js访问范围默认禁用。注意：该方法只影响file scheme类型的资源，其他类型资源如图片类型的，
     * 不会受到影响。如果getAllowUniversalAccessFromFileURLs为true，则该方法被忽略。
     * ICE_CREAM_SANDWICH_MR1版本以及以下默认为true，JELLY_BEAN版本以上默认为false
     */
    setAllowFileAccessFromFileURLs(boolean flag)

    /**
     * 设置存储定位数据库的位置，考虑到位置权限和持久化Cache缓存，Application需要拥有指定路径的
     * write权限
     */
    setGeolocationDatabasePath(String databasePath)

    /**
     * 是否允许Cache，默认false。考虑需要存储缓存，应该为缓存指定存储路径setAppCachePath
     */
    setAppCacheEnabled(boolean flag)

    /**
     * 设置Cache API缓存路径。为了保证可以访问Cache，Application需要拥有指定路径的write权限。
     * 该方法应该只调用一次，多次调用自动忽略。
     */
    setAppCachePath(String appCachePath)

    /**
     * 是否允许数据库存储。默认false。查看setDatabasePath API 如何正确设置数据库存储。
     * 该设置拥有全局特性，同一进程所有WebView实例共用同一配置。注意：保证在同一进程的任一WebView
     * 加载页面之前修改该属性，因为在这之后设置WebView可能会忽略该配置
     */
    setDatabaseEnabled(boolean flag)

    /**
     * 是否存储页面DOM结构，默认false。
     */
    setDomStorageEnabled(boolean flag)

    /**
     * 是否允许定位，默认true。注意：为了保证定位可以使用，要保证以下几点：
     * Application 需要有android.Manifest.permission#ACCESS_COARSE_LOCATION的权限
     * Application 需要实现WebChromeClient#onGeolocationPermissionsShowPrompt的回调，
     * 接收Js定位请求访问地理位置的通知
     */
    setGeolocationEnabled(boolean flag)

    /**
     * 是否允许JS自动打开窗口。默认false
     */
    setJavaScriptCanOpenWindowsAutomatically(boolean flag)

    /**
     * 设置页面的编码格式，默认UTF-8
     */
    setDefaultTextEncodingName(String encoding)

    /**
     * 设置WebView代理，默认使用默认值
     */
    setUserAgentString(String ua)

    /**
     * 通知WebView是否需要设置一个节点获取焦点当
     * WebView#requestFocus(int,android.graphics.Rect)被调用的时候，默认true
     */
    setNeedInitialFocus(boolean flag)

    /**
     * 基于WebView导航的类型使用缓存：正常页面加载会加载缓存并按需判断内容是否需要重新验证。
     * 如果是页面返回，页面内容不会重新加载，直接从缓存中恢复。setCacheMode允许客户端根据指定的模式来
     * 使用缓存。
     * LOAD_DEFAULT 默认加载方式
     * LOAD_CACHE_ELSE_NETWORK 按网络情况使用缓存
     * LOAD_NO_CACHE 不使用缓存
     * LOAD_CACHE_ONLY 只使用缓存
     */
    setCacheMode(int mode)

    /**
     * 设置加载不安全资源的WebView加载行为。KITKAT版本以及以下默认为MIXED_CONTENT_ALWAYS_ALLOW方
     * 式，LOLLIPOP默认MIXED_CONTENT_NEVER_ALLOW。强烈建议：使用MIXED_CONTENT_NEVER_ALLOW
     */
    setMixedContentMode(int mode)

#### 通过JS调用Java代码

    // 设置JS支持
    webSettings.setJavaScriptEnabled(true);
    // Activity对象注入到WebView中，在WebView中的对象别名叫android
    webView.addJavascriptInterface(this, "android");

    // 在JS调用的Java方法前要加上@JavascriptInterface注解
    // 在JS中调用的方法名要和Java中方法名一致

#### 通过Java调用JS代码

#### WebViewClient中函数概述

    /**
     * 在开始加载网页时会回调
     */
    public void onPageStarted(WebView view, String url, Bitmap favicon)

    /**
     * 在结束加载网页时会回调
     */
    public void onPageFinished(WebView view, String url)

    /**
     * 拦截 url 跳转,在里边添加点击链接跳转或者操作
     */
    public boolean shouldOverrideUrlLoading(WebView view, String url)

    /**
     * 加载错误的时候会回调，在其中可做错误处理，比如再请求加载一次，或者提示404的错误页面
     */
    public void onReceivedError(WebView view, int errorCode,String description, String failingUrl)

    /**
     * 当接收到https错误时，会回调此函数，在其中可以做错误处理
     */
    public void onReceivedSslError(WebView view, SslErrorHandler handler,SslError error)
    SslErrorHandler有两种操作cancel和proceed，如果选择proceed的话需要将super注释掉

    /**
     * 在每一次请求资源时，都会通过这个函数来回调
     */
    public WebResourceResponse shouldInterceptRequest(WebView view,
            String url) {
        return null;
    }

    /**
     * 在加载页面资源时会调用，每一个资源（比如图片）的加载都会调用一次
     */
    public void onLoadResource(WebView view, String url)

     /**
     *  (WebView发生改变时调用)
     *  可以参考http://www.it1352.com/191180.html的用法
     */
     public void onScaleChanged(WebView view, float oldScale, float newScale)

     /**
     * 重写此方法才能够处理在浏览器中的按键事件。
     * 是否让主程序同步处理Key Event事件，如过滤菜单快捷键的Key Event事件。
     * 如果返回true，WebView不会处理Key Event，
     * 如果返回false，Key Event总是由WebView处理。默认：false
     */
    public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event)

     /**
     * 是否重发POST请求数据，默认不重发。
     */
    onFormResubmission(WebView view, Message dontResend, Message resend)

     /**
     * 更新访问历史
     */
    doUpdateVisitedHistory(WebView view, String url, boolean isReload)

     /**
     * 通知主程序输入事件不是由WebView调用。是否让主程序处理WebView未处理的Input Event。
     * 除了系统按键，WebView总是消耗掉输入事件或shouldOverrideKeyEvent返回true。
     * 该方法由event 分发异步调用。注意：如果事件为MotionEvent，则事件的生命周期只存在方法调用过程中，
     * 如果WebViewClient想要使用这个Event，则需要复制Event对象。
     */
    onUnhandledInputEvent(WebView view, InputEvent event)

     /**
     * 通知主程序执行了自动登录请求。
     */
    onReceivedLoginRequest(WebView view, String realm, String account, String args)

    /**
     * 通知主程序：WebView接收HTTP认证请求，主程序可以使用HttpAuthHandler为请求设置WebView响应。默认取消请求。
     */
    onReceivedHttpAuthRequest(WebView view, HttpAuthHandler handler, String host, String realm)

    /**
     * 通知主程序处理SSL客户端认证请求。如果需要提供密钥，主程序负责显示UI界面。
     * 有三个响应方法：proceed(), cancel() 和 ignore()。
     * 如果调用proceed()和cancel()，webview将会记住response，
     * 对相同的host和port地址不再调用onReceivedClientCertRequest方法。
     * 如果调用ignore()方法，webview则不会记住response。该方法在UI线程中执行，
     * 在回调期间，连接被挂起。默认cancel()，即无客户端认证
     */
    onReceivedClientCertRequest(WebView view, ClientCertRequest request)


    > 为了防止字符冲突，在传递loadData的数据时，必须使用URLEncoder.encode()函数来转义


