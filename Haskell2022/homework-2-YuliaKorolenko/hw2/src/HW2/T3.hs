module HW2.T3
( joinOption    
, joinExcept   
, joinAnnotated 
, joinList 
, concatList     
, joinFun       
) where
-- joinF :: F (F a) -> F a

import HW2.T1 (Option(..), Annotated(..), Except(..), List(..), Fun(..))

concatList :: List a -> List a -> List a
concatList (a :. tail_a) b = a :. (concatList tail_a b)
concatList Nil b           = b

joinOption    :: Option (Option a) -> Option a
joinOption (Some None) = None
joinOption None = None
joinOption (Some (Some a)) = Some a

joinExcept    :: Except e (Except e a) -> Except e a
joinExcept (Success (a)) = a
joinExcept (Error e )    = Error e

joinAnnotated :: Semigroup e => Annotated e (Annotated e a) -> Annotated e a
joinAnnotated ((a :# ann_0) :# ann_1) = a :# (ann_0 <> ann_1)

joinList      :: List (List a) -> List a
joinList (head_0 :. t) = concatList head_0 (joinList t)
joinList (Nil)            = Nil

joinFun       :: Fun i (Fun i a) -> Fun i a
joinFun  (F f) = F (\i -> let (F fun_b) = f i 
                          in fun_b i)
                          