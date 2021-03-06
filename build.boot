(set-env!
 :source-paths   #{"cljs" "clj"}
 :resource-paths #{"resources"}
 :dependencies '[[adzerk/boot-cljs "2.1.4" :scope "test"]
                 [adzerk/boot-reload "0.5.2" :scope "test"]
                 [org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.9.946"]
                
                 [org.clojure/data.json "1.0.0"] 
                 [org.clojure/core.async "1.0.567"]
                 [cheshire "5.8.0"]             
                 [environ "1.1.0"]
                 [boot-environ "1.1.0"]

                 [brave/swords "0.1.2-SNAPSHOT"]      
                 [org.danielsz/system "0.4.1"]
                 [org.clojure/tools.nrepl "0.2.12"]
                 
                 [ring "1.6.2"]
                 [ring/ring-defaults "0.3.1"]
                 [compojure "1.6.0"]
                                
                 [http-kit "2.2.0"]
                 [com.taoensso/sente "1.12.0"]

                 [hara/time "3.0.11"]
                 [hara/io.scheduler "3.0.11"]

                 [rum "0.10.8"]
                 [org.roman01la/citrus "3.0.1"]

                 [chronoid "0.1.1"]
                 [mantra "0.6.0"]

                 [metosin/potpuri "0.5.1"]
                 [ubergraph "0.5.0"]

                 [cljsjs/howler "2.0.5-0"]

                 ])

(require
 '[adzerk.boot-cljs      :refer [cljs]]
 '[adzerk.boot-reload    :refer [reload]]
 '[dashboard.core :refer [dev-system prod-system]]
 '[environ.boot :refer [environ]]
 '[system.boot :refer [system run]])

(deftask dev
  "Run a restartable system in the Repl"
  []
  (comp
   (environ :env {:http-port "3000"})
   (watch :verbose true)
   (system :sys #'dev-system :auto true :files ["handler.clj" "worlds.clj" "population.clj"])
   (reload)
   (cljs)
   (repl :server true :port 44444)))

(deftask dev-run
  "Run a dev system from the command line"
  []
  (comp
   (environ :env {:http-port "3000"})
   (cljs)
   (run :main-namespace "dashboard.core" :arguments [#'dev-system])
   (wait)))

(deftask prod-run
  "Run a prod system from the command line"
  []
  (comp
   (environ :env {:http-port "8008"
                  :repl-port "8009"})
   (cljs :optimizations :advanced)
   (run :main-namespace "dashboard.core" :arguments [#'prod-system])
   (wait)))


