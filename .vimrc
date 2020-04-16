" Project configuration file.
" This template enables you to set configurations before any other vim stuff
" is loaded.
" For GUI configurations, use the 'script.gvimrc' template.

"" NOTE: to remember. Uncomment only what you need. When none of this is used,
"  `g:ycm_plugin_enabled` is the default and will be available.

" let g:ale_plugin_enabled = v:true            " Enable ALE plugin
" let g:android_plugin_enabled = v:true        " Enable Android plugin
" let g:ycm_plugin_enabled = v:true            " Enable YouCompleteMe plugin
" let g:syntastic_plugin_enabled = v:true      " Enable Syntastic plugin
" let g:lsp_plugin_enabled = v:true            " Enable vim-lsp, vim-lsp-settings, asyncomplete, asyncomplete-lsp
" let g:coc_plugin_enabled = v:true            " Enable coc-nvim plugin.
" let g:devicons_enabled = v:true              " Enable WebDevIcons.
let g:airline_powerline_fonts = 1            " Enable powerline fonts in airline
let g:loaded_dbext = 1                        " Disable DBExt plugin (not installed in pack directory)

let g:color_light = 'csharp'                  " Sets color for day light.
let g:color_night = 'fu'                      " Sets color for night.

" let g:NERDTreeWinSize=48
let g:NERDTreeMinimalUI=1
let g:NERDTreeDirArrowExpandable = '▶'
let g:NERDTreeDirArrowCollapsible = '▼'

" Keep this line. It will asure that Vim will start smothly.
source $HOME/.vim/vimrc

let g:fc_DontUseDefault = 1
set guifont=D2CodingForPowerline:h12
set diffopt=filler,iwhite
set previewheight=20

" For configuring GUI
augroup project_init
  au!
  au GUIEnter * set columns=190 lines=99
  au BufEnter * call mylib#manageSigns('js', 'java')
augroup END

