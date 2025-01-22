export function DownloadButton() {
  return (
    <div className="not-prose flex flex-col items-center py-4">
      <a
        href="https://github.com/eguchi1611/medipro/releases/latest/download/medipro.jar"
        target="_blank"
        rel="noopener noreferrer"
        className="flex w-64 items-center justify-center rounded bg-primary-500 px-4 py-4 font-mono text-lg text-white no-underline"
      >
        ダウンロードはこちら
      </a>
      <div className="mt-1 text-sm">Windows, macOS, Linuxに対応</div>
    </div>
  );
}
