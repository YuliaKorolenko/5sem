module Main (main) where

import System.Console.Haskeline
import Control.Monad.IO.Class
import HW3.Parser
import HW3.Evaluator
import HW3.Pretty
import Prelude

main :: IO ()
main = runInputT defaultSettings loop
   where
       loop :: InputT IO ()
       loop = do
           minput <- getInputLine "% "
           case minput of
               Nothing -> return ()
               Just "quit" -> return ()
               Just input -> do 
                  pf <- getExternalPrint  
                  case parse input of
                      Left parseError -> liftIO $ pf $ show parseError
                      Right parsed -> do
                          let evaluateResult = eval parsed
                          r <- liftIO evaluateResult
                          case r of
                             Left evalError -> liftIO $ pf $ show evalError
                             Right value -> liftIO $ pf $ show $ prettyValue value
                  loop
               