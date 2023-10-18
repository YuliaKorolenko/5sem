module HW2.T4
( mapState 
, wrapState 
, joinState 
, modifyState
, Prim(..)
, Expr(..)
, eval
, binaryOp
, unaryOp
) where

import qualified Control.Monad
import HW2.T1 (Annotated(..))

data State s a = S { runS :: s -> Annotated s a }

wrapState :: a -> State s a
wrapState a = S (\s -> a :# s)

mapState :: (a -> b) -> State s a -> State s b
mapState f state_a = S (\s -> let (a :# e) = runS state_a s
                              in (f a) :# e)

joinState :: State s (State s a) -> State s a
joinState state = S (\s -> let (inside :# e) = runS state s
                           in runS inside e)

-- типа runS :: s -> () :# s
modifyState :: (s -> s) -> State s ()
modifyState f = S (\s -> () :# f s)


instance Functor (State s) where
  fmap = mapState

instance Applicative (State s) where
  pure = wrapState
  p <*> q = Control.Monad.ap p q

instance Monad (State s) where
  m >>= f = joinState (fmap f m)


data Prim a =
    Add a a      -- (+)
  | Sub a a      -- (-)
  | Mul a a      -- (*)
  | Div a a      -- (/)
  | Abs a        -- abs
  | Sgn a        -- signum

data Expr = Val Double | Op (Prim Expr)

instance Num Expr where
  x + y    = Op (Add x y)
  x * y    = Op (Mul x y)
  x - y    = Op (Sub x y)
  abs x    = Op (Abs x)
  signum a = Op (Sgn a)
  fromInteger x = Val (fromInteger x)

instance Fractional Expr where
  x / y    = Op (Div x y)
  fromRational x = Val (fromRational x)

eval :: Expr -> State [Prim Double] Double
eval (Val var) = return var
eval (Op oper) = 
    case oper of
        (Add x y) -> binaryOp x y Add (+)
        (Sub x y) -> binaryOp x y Sub (-)
        (Mul x y) -> binaryOp x y Mul (*)
        (Div x y) -> binaryOp x y Div (/)
        (Abs x)   -> unaryOp x Abs abs
        (Sgn x)   -> unaryOp x Sgn signum

binaryOp :: Expr -> Expr -> (Double -> Double -> Prim Double) -> (Double -> Double -> Double) -> State [Prim Double] Double
binaryOp x y pr f
    = do x1 <- eval x
         y1 <- eval y
         modifyState (pr x1 y1 :)
         return (f x1 y1)

unaryOp :: Expr -> (Double -> Prim Double) -> (Double -> Double) -> State [Prim Double] Double
unaryOp x pr f = do
    x1 <- eval x
    modifyState (pr x1 :)
    return $ f x1





