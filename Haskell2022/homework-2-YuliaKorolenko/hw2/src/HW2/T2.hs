module HW2.T2
( distOption
, distPair
, distQuad
, distAnnotated
, distExcept
, distPrioritised
, distStream
, distList  
, distFun
, wrapOption 
, wrapPair        
, wrapQuad        
, wrapAnnotated   
, wrapExcept      
, wrapPrioritised 
, wrapStream      
, wrapList
, wrapFun         
) where

-- distPrioritisedдолжен выбрать более высокий приоритет из двух.
-- distListдолжен связать каждый элемент первого списка с каждым элементом второго списка (т. е. результирующий список имеет длину n × m).
-- Вы должны реализовать эти функции вручную, используя только:

-- типы данных, которые вы определили вHW2.T1
-- (<>)и memptyдляAnnotated    

import HW2.T1 (Option(..), Pair(..), Quad(..),  Annotated(..), Except(..), Prioritised(..), Stream(..), List(..), Fun(..))
import HW2.T3 (concatList)
-- distF :: (F a, F b) -> F (a, b)
-- wrapF :: a -> F a

distOption      :: (Option a, Option b) -> Option (a, b)
distOption (Some a, Some b) = Some (a, b)
distOption (None, _)                = None
distOption (_, None)                = None

distPair        :: (Pair a, Pair b) -> Pair (a, b)
distPair (P a_0 a_1, P b_0 b_1) = P (a_0, b_0) (a_1, b_1)

distQuad        :: (Quad a, Quad b) -> Quad (a, b)
distQuad (Q a_0 a_1 a_2 a_3, Q b_0 b_1 b_2 b_3) = Q (a_0, b_0) (a_1, b_1) (a_2, b_2) (a_3, b_3)

distAnnotated   :: Semigroup e => (Annotated e a, Annotated e b) -> Annotated e (a, b)
distAnnotated (a :# e_0, b :# e_1) = (a, b) :# (e_0 <> e_1)

distExcept      :: (Except e a, Except e b) -> Except e (a, b)
distExcept (Error e, _) = Error e
distExcept (_, Error e) = Error e
distExcept (Success a, Success b ) = Success (a, b)


distPrioritised :: (Prioritised a, Prioritised b) -> Prioritised (a, b)
distPrioritised x = 
  case x of
    (High a,   High b)   -> High (a, b)
    (High a,   Medium b) -> High (a, b)
    (High a,   Low b)    -> High (a, b)
    (Medium a, High b)   -> High (a, b)
    (Low a,    High b)   -> High (a, b)
    (Medium a, Medium b) -> Medium (a, b)
    (Medium a, Low b)    -> Medium (a, b)
    (Low a,    Medium b) -> Medium (a, b)
    (Low a,    Low b )   -> Low (a, b)      

distStream      :: (Stream a, Stream b) -> Stream (a, b)
distStream (a :> tail_a,  b :> tail_b) = (a, b) :> distStream(tail_a, tail_b)


distListHelper :: a -> List b -> List (a, b)
distListHelper a (b :. tail_b) = (a, b) :. distListHelper a tail_b
distListHelper _ _ = Nil

distList        :: (List a, List b) -> List (a, b)
distList (a :. tail_a, b) = (distListHelper a b) `concatList`  distList(tail_a, b)
distList _ = Nil

distFun         :: (Fun i a, Fun i b) -> Fun i (a, b)
distFun (F f_a, F f_b) = F (\x -> (f_a x, f_b x))


wrapOption      :: a -> Option a
wrapOption a = Some a

wrapPair        :: a -> Pair a
wrapPair a = P a a

wrapQuad        :: a -> Quad a
wrapQuad a = Q a a a a


wrapAnnotated   :: Monoid e => a -> Annotated e a
wrapAnnotated a = a :# mempty

wrapExcept      :: a -> Except e a
wrapExcept a = Success a

wrapPrioritised :: a -> Prioritised a
wrapPrioritised a = Low a

wrapStream      :: a -> Stream a
wrapStream a = a :> (wrapStream a)

wrapList        :: a -> List a
wrapList a = a :. Nil

wrapFun         :: a -> Fun i a
wrapFun a = F (\_ -> a)