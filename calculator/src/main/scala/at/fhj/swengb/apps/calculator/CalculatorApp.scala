package at.fhj.swengb.apps.calculator

import java.net.URL
import java.util.ResourceBundle
import javafx.application.Application
import javafx.beans.property.{ObjectProperty, SimpleObjectProperty}
import javafx.fxml.{FXML, FXMLLoader, Initializable}
import javafx.scene.control.TextField
import javafx.scene.{Parent, Scene}
import javafx.stage.Stage

import scala.util.{Failure, Success}
import scala.util.control.NonFatal

object CalculatorApp {

  def main(args: Array[String]): Unit = {
    Application.launch(classOf[CalculatorFX], args: _*)
  }
}

class CalculatorFX extends javafx.application.Application {

  val fxml = "/at/fhj/swengb/apps/calculator/calculator.fxml"
  val css = "/at/fhj/swengb/apps/calculator/calculator.css"

  def mkFxmlLoader(fxml: String): FXMLLoader = {
    new FXMLLoader(getClass.getResource(fxml))
  }

  override def start(stage: Stage): Unit =
    try {
      stage.setTitle("Calculator")
      setSkin(stage, fxml, css)
      stage.show()
      stage.setMinWidth(stage.getWidth)
      stage.setMinHeight(stage.getHeight)
    } catch {
      case NonFatal(e) => e.printStackTrace()
    }

  def setSkin(stage: Stage, fxml: String, css: String): Boolean = {
    val scene = new Scene(mkFxmlLoader(fxml).load[Parent]())
    stage.setScene(scene)
    stage.getScene.getStylesheets.clear()
    stage.getScene.getStylesheets.add(css)
  }

}

class CalculatorFxController extends Initializable {

  val calculatorProperty: ObjectProperty[RpnCalculator] = new SimpleObjectProperty[RpnCalculator](RpnCalculator())

  def getCalculator() : RpnCalculator = calculatorProperty.get()

  def setCalculator(rpnCalculator : RpnCalculator) : Unit = calculatorProperty.set(rpnCalculator)

  @FXML var result : TextField = _

  override def initialize(location: URL, resources: ResourceBundle) = {

  }

  def sgn(): Unit = {
    getCalculator().push(Op(result.getText)) match {
      case Success(c) => setCalculator(c)
      case Failure(e) => // show warning / error
    }
    getCalculator().stack foreach println
  }




  def c() : Unit = {
    result.setText("")
  }

  def plus_minus() : Unit = {
    result.setText("+/-")
  }

  def percent() : Unit =  {
    result.setText("%")

  }




  def divide() : Unit = {
    result.setText("/")
  }

  def multiply() : Unit = {
    result.setText("*")
  }

  def minus() : Unit = {
    result.setText("-")
  }

  def plus() : Unit = {
    result.setText("+")

  }

  def enter() : Unit = {
    result.setText("=")
  }

  def comma() : Unit = {
    result.setText(",")
  }




  def zero() : Unit = {
    result.setText("0")
  }
  def one() : Unit = {
    result.setText("1")
  }

  def two() : Unit = {
    result.setText("2")
  }
  def three() : Unit = {
    result.setText("3")
  }

  def four() : Unit = {
    result.setText("4")
  }

  def five() : Unit = {
    result.setText("5")
  }

  def six() : Unit = {
    result.setText("6")
  }

  def seven() : Unit = {
    result.setText("7")
  }

  def eight() : Unit = {
    result.setText("8")
  }

  def nine() : Unit = {
    result.setText("9")
  }


}

