package com.ableassist.ui.reader

import android.graphics.Color
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.text.Spannable
import android.text.SpannableString
import android.text.style.BackgroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ableassist.databinding.FragmentSmartReaderBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class SmartReaderFragment : Fragment(), TextToSpeech.OnInitListener {

    private var _binding: FragmentSmartReaderBinding? = null
    private val binding get() = _binding!!

    private var tts: TextToSpeech? = null
    private var isPlaying = false
    private var fullText = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSmartReaderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tts = TextToSpeech(requireContext(), this)

        // Get text from arguments (passed from Scanner)
        fullText = arguments?.getString("recognizedText") ?: "No text detected."
        binding.tvContent.text = fullText

        binding.btnPlay_pause.setOnClickListener {
            if (isPlaying) pauseReading() else startReading()
        }

        binding.btnStop.setOnClickListener {
            stopReading()
        }
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            tts?.language = Locale.getDefault()
            setupTtsProgressListener()
        }
    }

    private fun setupTtsProgressListener() {
        tts?.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
            override fun onStart(utteranceId: String?) {
                activity?.runOnUiThread {
                    isPlaying = true
                    binding.btnPlay_pause.text = "Pause"
                }
            }

            override fun onDone(utteranceId: String?) {
                activity?.runOnUiThread {
                    isPlaying = false
                    binding.btnPlay_pause.text = "Play"
                    clearHighlight()
                }
            }

            override fun onError(utteranceId: String?) {}

            override fun onRangeStart(utteranceId: String?, start: Int, end: Int, frame: Int) {
                activity?.runOnUiThread {
                    highlightText(start, end)
                }
            }
        })
    }

    private fun startReading() {
        if (fullText.isNotEmpty()) {
            val params = Bundle()
            params.putString(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "id")
            tts?.speak(fullText, TextToSpeech.QUEUE_FLUSH, params, "id")
        }
    }

    private fun pauseReading() {
        tts?.stop()
        isPlaying = false
        binding.btnPlay_pause.text = "Play"
        clearHighlight()
    }

    private fun stopReading() {
        tts?.stop()
        isPlaying = false
        binding.btnPlay_pause.text = "Play"
        clearHighlight()
    }

    private fun highlightText(start: Int, end: Int) {
        val spannable = SpannableString(fullText)
        spannable.setSpan(
            BackgroundColorSpan(Color.YELLOW),
            start,
            end,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.tvContent.text = spannable
    }

    private fun clearHighlight() {
        binding.tvContent.text = fullText
    }

    override fun onDestroyView() {
        super.onDestroyView()
        tts?.shutdown()
        _binding = null
    }
}
