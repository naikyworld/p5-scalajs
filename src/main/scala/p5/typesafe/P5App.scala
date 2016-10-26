package p5.typesafe

import p5.p5Global

import scala.scalajs.js.JSApp

/**
  * Created by fred on 23/10/2016.
  */
trait State

trait P5App[E] extends JSApp {

  def initialState: E

  def setup(state: E): Any

  def draw(state: E): Any

  def updateState(state: E): Unit = {
    local_state = state
  }
  private var local_state: E = initialState

  def main(): Unit = {

    p5Global.setup = () => {
      setup(local_state)
      ()
    }
    p5Global.draw = () => {
      draw(local_state)
      ()
    }

  }

}
