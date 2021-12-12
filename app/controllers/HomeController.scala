package controllers

import javax.inject._
import play.api._
import play.api.mvc._
/** ---Resultクラスを使う際、追加でインポート--- */
import akka.util._
import play.api.http._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
//  def index() = Action { implicit request: Request[AnyContent] =>
//    Ok(views.html.index())
//  }


    /**
     * Ok関数内で指定したデフォルトのメッセージを表示
     */
//  def index() = Action {
//    Ok("Welcome to Play Framework!")
//  }


  /**
   * 「TODO」ダミーページを表示
   * 「とりあえずアクションメソッドを一通り用意しておいて、具体的な内容は後で作成する」
   * という時に使う開発時の便利機能
   */
  //  def index() = TODO


  /**
   * 【第１引数】Resultクラス（クライアントに情報を返送するレスポンスを扱うクラス）
   * 〇ResponseHeader( 整数 , (Map) ) = レスポンスのヘッダー情報
   *   ・（第１引数）整数　＝　ステータス番号
   *   ・（第２引数）Map　＝　必要なヘッダー情報をまとめたもの（【scala】: scala.predef.Map　【Java】:java.util.Map(=HashMap))
   *
   * 【第２引数】HttpEntityクラス（HTTPレスポンスのボディ部分を管理するクラス）
   * 〇HttpEntity.Strict(《ByteString》, 《Some》)
   *  ※いくつかあるHttpEntityのサブクラスの中でもっとも一般的に用いられるクラス
   *   ・（第１引数）ByteString　＝　実際にコンテンツとして出力されるテキスト
   *   ・（第２引数）Some　＝　テキストの値を指定
   */
  //  def index() = Action {
//    Result(
//      header = ResponseHeader(200, Map.empty),
//      body = HttpEntity.Strict(
//        ByteString("This is sample text."),
//        Some("text/plain")
//      )
//    )
//  }


  /**
   * Ok関数の中身でhtmlタグを指定し、内容を出力
   * .as以降で出力形式をしていしている
   */
  //  def index() = Action {
//    Ok("<h1>Hello!</h1><p>This is sample message.</p>")
//      .as("text/html")
//  }


  /**
   * 上記をxml形式で出力
   * ※Chromeではスタイルと関連付けられていないというメッセージが表示される
   */
  //  def index() = Action {
//    Ok("<root><title>Hello!</title><message>This is sample " +
//      "message.</message></root>")
//      .as("application/xml")
//  }


  /**
   * 上記をjson形式で出力
   */
  //  def index() = Action {
//    Ok("{title:'Hello!', message:'This is sample message.'}")
//      .as("application/json")
//  }


  /**
   * HTMLのソースコードにヘッダー情報を設定する方法
   * 《Result》.withHeaders( キー　-> 値 , キー -> 値 , ......)
   *   ※ヘッダー項目はAbstractControllerクラスにフィールドまたはメンバ変数として用意されている
   * 　※設定するヘッダー項目を必要なだけ用意する
   */
  //  def index() = Action {
//    Ok("<title>Hello!</title><h1>Hello!</h1><p>サンプルのメッセージ。</p>")
//      .withHeaders(
//        ACCEPT_CHARSET->"utf-8",    // キャラクタセットをUTF-8に設定
//        ACCEPT_LANGUAGE->"ja-JP")   // 使用言語・地域をja-JPに設定
//      .as("text/html")
//  }


  /**
   * Int型のidをパラメーターから受け取り、値をセットして出力
   *
   * @param id
   * @return
   */
//  def index(id:Int) = Action {
//    Ok("<title>Hello!</title><h1>Hello!</h1><p>ID = "
//      + id + " です。</p>")
//      .as("text/html")
//  }


  /**
   * Int型のid、String型のnameをパラメーターから受け取り、値をセットして出力
   * ２つのパラメーターを渡す場合の記述形式は、今回は「/:id+:name」としているが、
   * 「/:id/:name」でも、「/:id=:name」でも問題ない。
   * （１つ１つの値が区別され、かつURLで利用可能な文字で記述されていれば良い。）
   *
   * @param id　【指定必須】
   * @param name　【指定必須】
   * @return
   */
//  def index(id:Int, name:String) = Action {
//    Ok("<title>Hello!</title><h1>Hello!</h1><p>ID = "
//      + id + ", NAME = " + name + " です。</p>")
//      .as("text/html")
//  }


  /**
   * 上記と同じ処理。ただし、 nameにオプションパラメーターを使用。（未指定でもエラーにならない）
   * nameがnullの場合はgetOrElse()メソッド内で指定した文字を出力。
   * 記述する場合はidを指定した後に「?name=○○」と書く
   *
   * @param id　【指定必須】
   * @param name　【任意】
   * @return
   */
//  def index(id:Int, name:Option[String]) = Action {
//    Ok("<title>Hello!</title><h1>Hello!</h1><p>ID = "
//      + id + ", NAME = " + name.getOrElse("no-name") + " です。</p>")
//      .as("text/html")
//  }


  /**
   * パラメーターで渡されたnameをクッキーに保存する。（最近はセッションが使われることが多い）
   * 【保存】
   * 《Result》.withCookies(《Cookie》).bakeCookies()
   *    ・withCookies：引数に指定したCookieを追加したResultを返す
   *    ・bakeCookies：追加されたCookieを元に、HTTPのSet-Cookieヘッダー情報を作成
   *   Resultがクライアントに送信されるとbakeCookiesされたヘッダー情報により、クライアント側にクッキーが保存される。
   *
   * 【取得】
   *  変数 = 《Request》.cookies.get(キー)
   *
   * 【削除】
   * 《Result》.descardingCookies(DiscardingCookie(キー))
   *
   *
   * @param name
   * @return
   */
//  def index(name:Option[String]) = Action { request =>    // Requestを利用するため引き通に用意
//    val param:String = name.getOrElse("");    // パラメーターの値を取得（オプションパラメーター）
//    var message = "<p>nameはありません。</p>"    // 変数messageに値を設定
//    if(param != "") {
//      message = "<p>nameが送られました。</p>"    // パラメーターが送られた場合は出力
//    }
//    val cookie = request.cookies.get("name")  // Requestからクッキーを取得（nameキーのCookieインスタンスが取得される）
//    message += "<p>cookie: " + cookie.getOrElse(Cookie("name", "no-cookie.")).value + "</p>"
//    // getOrElseを使い、Cookieを取り出す
//    // クッキーが存在しなかった場合は、Cookie("name", "no-cookie.")として新たにCookieを作成して取り出す
//    // 得られたCookieのvalueの値を使ってmessageに値を表示
//    val res = Ok("<title>Hello!</title><h1>Hello!</h1>" + message)  // OkでResultを作成
//      .as("text/html")
//    if(param != "") {
//      res.withCookies(Cookie("name", param))    // paramの値が空でなければクッキーを追加（withCookies.bakeCookiesを利用）
//        .bakeCookies()
//    } else {
//      res
//    }
//  }

  /**
   * パラメーターから渡されたnameをセッションに保存する。
   * ※　セッション：クライアントとサーバーの連続した接続を維持するための仕組み
   *              様々な値を保存しておくことができ、セッションが維持されている限り、いつでもその値を取り出し、利用できる
   *              通常、セッションはブラウザを終了するまで維持される。
   *
   * 【保存】
   *  《Result》.withSession(《Session》)
   *  《Result》.withSession(キー , 値)
   *    ※引数には、セッションを管理るす「Session」クラスのインスタンスか、あるいはセッションに保管するキーと値を指定する。
   *
   * 【取得】
   *  変数　＝　request.session.get(キー)
   *
   * 【削除】
   *  《Result》.withNewSession
   *    ※引数もなく、呼び出すだけ
   *    ※セッションに保管されている値が全て消去される
   *
   *
   * @param name
   * @return
   */
  def index(name:Option[String]) = Action { request =>
    val param: String = name.getOrElse("");
    var message = "<p>nameはありません。</p>"
    if (param != "") {
      message = "<p>nameが送られました。</p>"
    }
    val session = request.session.get("name")
    val sessionvalue = session.getOrElse("no-session.")
    message += "<p>session: " + sessionvalue + "</p>"
    val res = Ok("<title>Hello!</title><h1>Hello!</h1>" + message)
      .as("text/html")
    if (param != "") {
      res.withSession(request.session + ("name" -> param))
    } else {
      res
    }
  }
}
